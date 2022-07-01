package com.l3udy.themeal.data.model

import com.google.gson.annotations.SerializedName

data class MealCategories(
    @SerializedName("categories")
    val categories: ArrayList<MealCategory> = ArrayList()
)