package com.example.themealapp.mealbycategory.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themealapp.mealbycategory.background.repository.MealsCategoryRepository
import com.example.themealapp.mealbycategory.background.response.MealsResponse

class MealsViewModel(private val mRepository: MealsCategoryRepository): ViewModel() {

    val mMealsList: LiveData<MealsResponse> = mRepository.mMeals

    fun getMealsByCategory(category: String){
        mRepository.getCategories(category)
    }

}