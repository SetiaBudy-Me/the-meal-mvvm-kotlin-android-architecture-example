package com.l3udy.themeal.data.model

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val id: String = "",

    @SerializedName("strMeal")
    val name: String = "",

    @SerializedName("strMealThumb")
    val thumb: String = ""
)