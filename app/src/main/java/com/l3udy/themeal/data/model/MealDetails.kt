package com.l3udy.themeal.data.model

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class MealDetails(
    @SerializedName("meals")
    val meals: ArrayList<JSONObject> = ArrayList()
)