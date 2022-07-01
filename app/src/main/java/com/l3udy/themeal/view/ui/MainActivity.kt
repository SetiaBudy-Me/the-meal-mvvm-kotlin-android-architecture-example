package com.l3udy.themeal.view.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.l3udy.themeal.R
import com.l3udy.themeal.data.model.MealCategory
import com.l3udy.themeal.view.adapter.MealCategoriesAdapter
import com.l3udy.themeal.viewmodel.MainViewModel
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag = Constants.TAG + " " + this::class.java.simpleName

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MealCategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, Constants.TAG_LINE)
        Log.d(tag, "onCreate")

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        adapter = MealCategoriesAdapter(arrayListOf())
        rvCategories.adapter = adapter
        rvCategories.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
    }

    private fun setupObserver() {
        viewModel.getMealCategories().observe(this) {
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

    private fun renderList(value: List<MealCategory>) {
        adapter.addData(value)
        adapter.notifyDataSetChanged()
    }
}
