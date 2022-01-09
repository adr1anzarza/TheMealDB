package com.example.themealapp.categories.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.categories.background.repository.MealRepository
import com.example.themealapp.categories.background.response.CategoriesResponse

class MainActivityViewModel(private val mRepository: MealRepository): ViewModel() {

    val mCategoriesList: LiveData<CategoriesResponse> = mRepository.mCategories

    init {
        getCategories()
    }

    private fun getCategories(){
        mRepository.getCategories()
    }

}