package com.example.themealapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.background.repository.MealRepository
import com.example.themealapp.background.response.CategoriesResponse

class MainActivityViewModel(private val mRepository: MealRepository): ViewModel() {

    val mCategoriesList: LiveData<CategoriesResponse> = mRepository.mCategories

    init {
        getCategories()
    }

    private fun getCategories(){
        mRepository.getCategories()
    }

}