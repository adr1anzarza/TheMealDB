package com.example.themealapp.mealbycategory.background.repository

import androidx.lifecycle.LiveData
import com.example.themealapp.mealbycategory.background.datasource.MealCategoryDatasource
import com.example.themealapp.mealbycategory.background.response.MealDetailResponse
import com.example.themealapp.mealbycategory.background.response.MealsResponse

class MealsCategoryRepository(private val mDataSource: MealCategoryDatasource) {

    val mMeals: LiveData<MealsResponse> = mDataSource.mMeals
    val mMealDetail: LiveData<MealDetailResponse> = mDataSource.mMealDetail

    fun getCategories(category: String){
        mDataSource.getMeals(category)
    }

    fun getMealDetail(id: String){
        mDataSource.getMealDetail(id)
    }

}