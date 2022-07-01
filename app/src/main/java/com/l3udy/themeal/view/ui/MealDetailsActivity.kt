package com.l3udy.themeal.view.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.l3udy.themeal.R
import com.l3udy.themeal.viewmodel.MealDetailsViewModel
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Status
import kotlinx.android.synthetic.main.activity_meal_details.*
import org.json.JSONObject

@SuppressLint("SetTextI18n")
class MealDetailsActivity : AppCompatActivity() {
    private val tag = Constants.TAG + " " + this::class.java.simpleName

    private lateinit var viewModel: MealDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
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
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MealDetailsViewModel::class.java]
    }

    private fun setupObserver() {
        viewModel.fetchMealDetails("${intent.getStringExtra("id")}")
        viewModel.getMealDetails().observe(this) {
            Log.d(tag, it.status.toString())
            when (it.status) {
                Status.SUCCESS -> {
                    llLoaderPage.visibility = View.GONE
                    it.data?.let { value -> setUI(value.getJSONArray("meals").getJSONObject(0)) }
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

    private fun setUI(mealDetails: JSONObject) {
        Glide.with(this)
            .load(mealDetails.getString("strMealThumb"))
            .into(ivThumb)

        tvName.text = mealDetails.getString("strMeal")
        tvCategory.text = mealDetails.getString("strCategory")
        tvInstructions.text = mealDetails.getString("strInstructions")

        if ((mealDetails.has("strIngredient1")) && (mealDetails.getString("strIngredient1") != "")) {
            tvIngredients1.visibility = View.VISIBLE
            tvIngredients1.text = "${mealDetails.getString("strIngredient1")} (${mealDetails.getString("strMeasure1")})"
        }

        if ((mealDetails.has("strIngredient2")) && (mealDetails.getString("strIngredient2") != "")) {
            tvIngredients2.visibility = View.VISIBLE
            tvIngredients2.text = "${mealDetails.getString("strIngredient2")} (${mealDetails.getString("strMeasure2")})"
        }

        if ((mealDetails.has("strIngredient3")) && (mealDetails.getString("strIngredient3") != "")) {
            tvIngredients3.visibility = View.VISIBLE
            tvIngredients3.text = "${mealDetails.getString("strIngredient3")} (${mealDetails.getString("strMeasure3")})"
        }

        if ((mealDetails.has("strIngredient4")) && (mealDetails.getString("strIngredient4") != "")) {
            tvIngredients4.visibility = View.VISIBLE
            tvIngredients4.text = "${mealDetails.getString("strIngredient4")} (${mealDetails.getString("strMeasure4")})"
        }

        if ((mealDetails.has("strIngredient5")) && (mealDetails.getString("strIngredient5") != "")) {
            tvIngredients5.visibility = View.VISIBLE
            tvIngredients5.text = "${mealDetails.getString("strIngredient5")} (${mealDetails.getString("strMeasure5")})"
        }

        if ((mealDetails.has("strIngredient6")) && (mealDetails.getString("strIngredient6") != "")) {
            tvIngredients6.visibility = View.VISIBLE
            tvIngredients6.text = "${mealDetails.getString("strIngredient6")} (${mealDetails.getString("strMeasure6")})"
        }

        if ((mealDetails.has("strIngredient7")) && (mealDetails.getString("strIngredient7") != "")) {
            tvIngredients7.visibility = View.VISIBLE
            tvIngredients7.text = "${mealDetails.getString("strIngredient7")} (${mealDetails.getString("strMeasure7")})"
        }

        if ((mealDetails.has("strIngredient8")) && (mealDetails.getString("strIngredient8") != "")) {
            tvIngredients8.visibility = View.VISIBLE
            tvIngredients8.text = "${mealDetails.getString("strIngredient8")} (${mealDetails.getString("strMeasure8")})"
        }

        if ((mealDetails.has("strIngredient9")) && (mealDetails.getString("strIngredient9") != "")) {
            tvIngredients9.visibility = View.VISIBLE
            tvIngredients9.text = "${mealDetails.getString("strIngredient9")} (${mealDetails.getString("strMeasure9")})"
        }

        if ((mealDetails.has("strIngredient10")) && (mealDetails.getString("strIngredient10") != "")) {
            tvIngredients10.visibility = View.VISIBLE
            tvIngredients10.text = "${mealDetails.getString("strIngredient10")} (${mealDetails.getString("strMeasure10")})"
        }

        if ((mealDetails.has("strIngredient11")) && (mealDetails.getString("strIngredient11") != "")) {
            tvIngredients11.visibility = View.VISIBLE
            tvIngredients11.text = "${mealDetails.getString("strIngredient11")} (${mealDetails.getString("strMeasure11")})"
        }

        if ((mealDetails.has("strIngredient12")) && (mealDetails.getString("strIngredient12") != "")) {
            tvIngredients12.visibility = View.VISIBLE
            tvIngredients12.text = "${mealDetails.getString("strIngredient12")} (${mealDetails.getString("strMeasure12")})"
        }

        if ((mealDetails.has("strIngredient13")) && (mealDetails.getString("strIngredient13") != "")) {
            tvIngredients13.visibility = View.VISIBLE
            tvIngredients13.text = "${mealDetails.getString("strIngredient13")} (${mealDetails.getString("strMeasure13")})"
        }

        if ((mealDetails.has("strIngredient14")) && (mealDetails.getString("strIngredient14") != "")) {
            tvIngredients14.visibility = View.VISIBLE
            tvIngredients14.text = "${mealDetails.getString("strIngredient14")} (${mealDetails.getString("strMeasure14")})"
        }

        if ((mealDetails.has("strIngredient15")) && (mealDetails.getString("strIngredient15") != "")) {
            tvIngredients15.visibility = View.VISIBLE
            tvIngredients15.text = "${mealDetails.getString("strIngredient15")} (${mealDetails.getString("strMeasure15")})"
        }

        if ((mealDetails.has("strIngredient16")) && (mealDetails.getString("strIngredient16") != "")) {
            tvIngredients16.visibility = View.VISIBLE
            tvIngredients16.text = "${mealDetails.getString("strIngredient16")} (${mealDetails.getString("strMeasure16")})"
        }

        if ((mealDetails.has("strIngredient17")) && (mealDetails.getString("strIngredient17") != "")) {
            tvIngredients17.visibility = View.VISIBLE
            tvIngredients17.text = "${mealDetails.getString("strIngredient17")} (${mealDetails.getString("strMeasure17")})"
        }

        if ((mealDetails.has("strIngredient18")) && (mealDetails.getString("strIngredient18") != "")) {
            tvIngredients18.visibility = View.VISIBLE
            tvIngredients18.text = "${mealDetails.getString("strIngredient18")} (${mealDetails.getString("strMeasure18")})"
        }

        if ((mealDetails.has("strIngredient19")) && (mealDetails.getString("strIngredient19") != "")) {
            tvIngredients19.visibility = View.VISIBLE
            tvIngredients19.text = "${mealDetails.getString("strIngredient19")} (${mealDetails.getString("strMeasure19")})"
        }

        if ((mealDetails.has("strIngredient20")) && (mealDetails.getString("strIngredient20") != "")) {
            tvIngredients20.visibility = View.VISIBLE
            tvIngredients20.text = "${mealDetails.getString("strIngredient20")} (${mealDetails.getString("strMeasure20")})"
        }
    }
}
