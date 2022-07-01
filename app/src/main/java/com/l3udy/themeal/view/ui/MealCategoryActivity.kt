package com.l3udy.themeal.view.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.l3udy.themeal.R
import com.l3udy.themeal.data.model.Meal
import com.l3udy.themeal.view.adapter.MealsAdapter
import com.l3udy.themeal.viewmodel.MealCategoryViewModel
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Status
import kotlinx.android.synthetic.main.activity_meal_category.*
import org.json.JSONObject

class MealCategoryActivity : AppCompatActivity() {
    private val tag = Constants.TAG + " " + this::class.java.simpleName

    private lateinit var viewModel: MealCategoryViewModel
    private lateinit var adapter: MealsAdapter
    private lateinit var category: JSONObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_category)
        Log.d(tag, Constants.TAG_LINE)
        Log.d(tag, "onCreate")

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        ibBack.setOnClickListener {
            finish()
        }

        category = JSONObject(intent.getStringExtra("data")!!)
        Glide.with(this)
            .load(category.getString("thumb"))
            .into(ivThumb)

        tvCategoryName.text = category.getString("name")
        tvDescription.text = category.getString("description")

        adapter = MealsAdapter(arrayListOf())
        rvMeals.adapter = adapter
        rvMeals.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MealCategoryViewModel::class.java]
    }

    private fun setupObserver() {
        viewModel.fetchMeals(category.getString("name"))
        viewModel.getMeals().observe(this) {
            Log.d(tag, it.status.toString())
            when (it.status) {
                Status.SUCCESS -> {
                    llLoaderPage.visibility = View.GONE
                    it.data?.let { value -> renderList(value) }
                }
                Status.LOADING -> {
                    llLoaderPage.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    llLoaderPage.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(value: List<Meal>) {
        adapter.addData(value)
        adapter.notifyDataSetChanged()
    }
}
