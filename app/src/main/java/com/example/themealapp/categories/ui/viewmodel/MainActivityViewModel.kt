package com.example.themealapp.categories.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.categories.background.repository.MealRepository
import com.example.themealapp.categories.background.response.CategoriesResponse
import com.example.themealapp.categories.background.response.Category
import com.example.themealapp.categories.background.response.RandomMealResponse

class MainActivityViewModel(private val mRepository: MealRepository): ViewModel() {

    val mCategoriesList: LiveData<CategoriesResponse> = mRepository.mCategories
    val mRandomMeals: LiveData<RandomMealResponse> = mRepository.mRandomMeals

    private val _navigateToSelectedProperty = MutableLiveData<Category>()

    val navigateToSelectedProperty: LiveData<Category>
        get() = _navigateToSelectedProperty

    private val _onRefreshData = MutableLiveData<Boolean>()
    var mOnRefresh: LiveData<Boolean> = _onRefreshData

    init {
        getCategories()
        getRandomMeals()
    }

    private fun getCategories() {
        mRepository.getCategories()
    }

    fun getRandomMeals() {
        mRepository.getRandomMeals()
    }

    fun displayPropertyDetails(category: Category) {
        _navigateToSelectedProperty.value = category
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun onOrderRefresh(){
        _onRefreshData.value = true
    }

    fun onDataRefreshed(){
        _onRefreshData.value = false
    }

}