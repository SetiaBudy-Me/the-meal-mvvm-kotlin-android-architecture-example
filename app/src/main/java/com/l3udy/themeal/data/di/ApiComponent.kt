package com.l3udy.themeal.data.di

import com.l3udy.themeal.data.api.Api
import com.l3udy.themeal.viewmodel.MainViewModel
import com.l3udy.themeal.viewmodel.MealCategoryViewModel
import com.l3udy.themeal.viewmodel.MealDetailsViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(api: Api)
    fun inject(viewModel: MainViewModel)
    fun inject(viewModel: MealCategoryViewModel)
    fun inject(viewModel: MealDetailsViewModel)
}