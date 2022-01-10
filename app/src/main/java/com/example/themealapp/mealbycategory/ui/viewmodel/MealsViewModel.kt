package com.example.themealapp.mealbycategory.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.mealbycategory.background.repository.MealsCategoryRepository
import com.example.themealapp.mealbycategory.background.response.Meal
import com.example.themealapp.mealbycategory.background.response.MealDetailResponse
import com.example.themealapp.mealbycategory.background.response.MealsResponse

class MealsViewModel(private val mRepository: MealsCategoryRepository): ViewModel() {

    val mMealsList: LiveData<MealsResponse> = mRepository.mMeals
    val mMealDetail: LiveData<MealDetailResponse> = mRepository.mMealDetail

    private val _navigateToSelectedMeal = MutableLiveData<Meal>()

    val navigateToSelectedMeal: LiveData<Meal>
        get() = _navigateToSelectedMeal

    fun getMealsByCategory(category: String){
        mRepository.getCategories(category)
    }

    fun getMealDetail(id: String){
        mRepository.getMealDetail(id)
    }

    fun displayMealDetails(meal: Meal) {
        _navigateToSelectedMeal.value = meal
    }

    fun displayMealDetailsComplete() {
        _navigateToSelectedMeal.value = null
    }

}