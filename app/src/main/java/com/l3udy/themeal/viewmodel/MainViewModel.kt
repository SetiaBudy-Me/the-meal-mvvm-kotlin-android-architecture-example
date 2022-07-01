package com.l3udy.themeal.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.themeal.data.api.Api
import com.l3udy.themeal.data.di.DaggerApiComponent
import com.l3udy.themeal.data.model.MealCategory
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private val tag = Constants.TAG + " " + this::class.java.simpleName
    private val composite = CompositeDisposable()
    private val mealCategories = MutableLiveData<Resource<List<MealCategory>>>()

    @Inject
    lateinit var api: Api

    init {
        DaggerApiComponent.create().inject(this)
        fetchMealCategories()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(tag, "onCleared")
        composite.clear()
    }

    private fun fetchMealCategories() {
        mealCategories.postValue(Resource.loading(null))
        composite.add(
            api.getMealCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    mealCategories.postValue(Resource.success(value.categories))
                }, { throwable ->
                    Log.d(tag, "ERROR: ${throwable.message}")
                    mealCategories.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    fun getMealCategories(): LiveData<Resource<List<MealCategory>>> {
        return mealCategories
    }
}