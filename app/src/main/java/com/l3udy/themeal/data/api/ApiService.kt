package com.l3udy.themeal.data.api

import com.l3udy.themeal.data.model.MealCategories
import com.l3udy.themeal.data.model.MealDetails
import com.l3udy.themeal.data.model.Meals
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Accept: application/json")
    @GET(BaseUrl.GET_MEAL_CATEGORIES)
    fun getMealCategories(): Single<MealCategories>

    @Headers("Accept: application/json")
    @GET(BaseUrl.GET_MEAL_BY_CATEGORY)
    fun getMealByCategory(@Query("c") category: String): Single<Meals>

    @Headers("Accept: application/json")
    @GET(BaseUrl.GET_MEAL_DETAILS)
    fun getMealDetails(@Query("i") id: String): Single<Any>
}