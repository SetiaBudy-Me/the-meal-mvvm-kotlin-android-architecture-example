package com.l3udy.themeal.data.api

import com.l3udy.themeal.data.di.DaggerApiComponent
import com.l3udy.themeal.data.model.MealCategories
import com.l3udy.themeal.data.model.Meals
import io.reactivex.Single
import javax.inject.Inject

class Api {

    @Inject
    lateinit var apiService: ApiService

    init {
        DaggerApiComponent.create().inject(this)
    }


    /** Meal */

    fun getMealCategories(): Single<MealCategories> {
        return apiService.getMealCategories()
    }

    fun getMealByCategory(category: String): Single<Meals> {
        return apiService.getMealByCategory(category)
    }

    fun getMealDetails(id: String): Single<Any> {
        return apiService.getMealDetails(id)
    }
}