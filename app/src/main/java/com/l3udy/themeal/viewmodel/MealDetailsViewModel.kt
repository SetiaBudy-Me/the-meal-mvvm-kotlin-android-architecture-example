package com.l3udy.themeal.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.l3udy.themeal.data.api.Api
import com.l3udy.themeal.data.di.DaggerApiComponent
import com.l3udy.themeal.utils.Constants
import com.l3udy.themeal.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

class MealDetailsViewModel : ViewModel() {

    private val tag = Constants.TAG + " " + this::class.java.simpleName
    private val composite = CompositeDisposable()
    private val mealDetails = MutableLiveData<Resource<JSONObject>>()

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

    fun fetchMealDetails(id: String) {
        mealDetails.postValue(Resource.loading(null))
        composite.add(
            api.getMealDetails(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    mealDetails.postValue(Resource.success(JSONObject(Gson().toJson(value))))
                }, { throwable ->
                    Log.d(tag, "Error: ${throwable.message}")
                    mealDetails.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    fun getMealDetails(): LiveData<Resource<JSONObject>> {
        return mealDetails
    }
}