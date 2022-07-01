package com.l3udy.themeal.data.api

object BaseUrl {
    // Production
    const val BASE_URL = "http://www.themealdb.com/api/json/v1/1/"

    // Development
    //const val BASE_URL = "http://www.themealdb.com/api/json/v1/1/"


    // Meal
    const val GET_MEAL_CATEGORIES = "categories.php"
    const val GET_MEAL_BY_CATEGORY = "filter.php"
    const val GET_MEAL_DETAILS = "lookup.php"
}