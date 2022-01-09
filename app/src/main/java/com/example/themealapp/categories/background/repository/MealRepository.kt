package com.example.themealapp.categories.background.repository

import androidx.lifecycle.LiveData
import com.example.themealapp.categories.background.datasource.MealDatasource
import com.example.themealapp.categories.background.response.CategoriesResponse

class MealRepository(private val mDataSource: MealDatasource) {

    val mCategories: LiveData<CategoriesResponse> = mDataSource.mCategories

    fun getCategories(){
        mDataSource.getCategories()
    }

}