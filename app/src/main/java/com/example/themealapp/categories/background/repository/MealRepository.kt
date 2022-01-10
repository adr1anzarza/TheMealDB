package com.example.themealapp.categories.background.repository

import androidx.lifecycle.LiveData
import com.example.themealapp.categories.background.datasource.MealDatasource
import com.example.themealapp.categories.background.response.CategoriesResponse
import com.example.themealapp.categories.background.response.RandomMealResponse

class MealRepository(private val mDataSource: MealDatasource) {

    val mCategories: LiveData<CategoriesResponse> = mDataSource.mCategories
    val mRandomMeals: LiveData<RandomMealResponse> = mDataSource.mRandomMealResponse

    fun getCategories(){
        mDataSource.getCategories()
    }

    fun getRandomMeals(){
        mDataSource.getRandomMeal()
    }

}