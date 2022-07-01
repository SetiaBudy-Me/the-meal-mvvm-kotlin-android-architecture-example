package com.l3udy.themeal.data.model

import com.google.gson.annotations.SerializedName

data class MealCategory(
    @SerializedName("idCategory")
    val id: Int = 0,

    @SerializedName("strCategory")
    val name: String = "",

    @SerializedName("strCategoryThumb")
    val thumb: String = "",

    @SerializedName("strCategoryDescription")
    val description: String = ""
)