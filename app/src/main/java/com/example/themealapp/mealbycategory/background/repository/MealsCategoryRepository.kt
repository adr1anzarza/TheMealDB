package com.example.themealapp.mealbycategory.background.repository

import androidx.lifecycle.LiveData
import com.example.themealapp.mealbycategory.background.datasource.MealCategoryDatasource
import com.example.themealapp.mealbycategory.background.response.MealsResponse

class MealsCategoryRepository(private val mDataSource: MealCategoryDatasource) {

    val mMeals: LiveData<MealsResponse> = mDataSource.mMeals

    fun getCategories(category: String){
        mDataSource.getMeals(category)
    }

}