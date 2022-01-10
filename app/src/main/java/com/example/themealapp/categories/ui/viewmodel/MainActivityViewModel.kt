package com.example.themealapp.categories.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.categories.background.repository.MealRepository
import com.example.themealapp.categories.background.response.CategoriesResponse
import com.example.themealapp.categories.background.response.Category

class MainActivityViewModel(private val mRepository: MealRepository): ViewModel() {

    val mCategoriesList: LiveData<CategoriesResponse> = mRepository.mCategories

    private val _navigateToSelectedProperty = MutableLiveData<Category>()

    val navigateToSelectedProperty: LiveData<Category>
        get() = _navigateToSelectedProperty

    init {
        getCategories()
    }

    private fun getCategories(){
        mRepository.getCategories()
    }

    fun displayPropertyDetails(category: Category) {
        _navigateToSelectedProperty.value = category
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

}