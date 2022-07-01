package com.l3udy.themeal.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.themeal.data.api.Api
import com.l3udy.themeal.data.di.DaggerApiComponent
import com.l3udy.themeal.data.model.Meal
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MealCategoryViewModel : ViewModel() {

    private val tag = Constants.TAG + " " + this::class.java.simpleName
    private val composite = CompositeDisposable()
    private val meals = MutableLiveData<Resource<List<Meal>>>()

    @Inject
    lateinit var api: Api

    init {
        DaggerApiComponent.create().inject(this)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(tag, "onCleared")
        composite.clear()
    }

    fun fetchMeals(category: String) {
        meals.postValue(Resource.loading(null))
        composite.add(
            api.getMealByCategory(category)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    meals.postValue(Resource.success(value.meals))
                }, { throwable ->
                    Log.d(tag, "throwable: ${throwable.message}")
                    meals.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    fun getMeals(): LiveData<Resource<List<Meal>>> {
        return meals
    }
}