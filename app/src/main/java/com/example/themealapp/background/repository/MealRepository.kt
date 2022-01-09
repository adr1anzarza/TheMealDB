package com.example.themealapp.background.repository

import androidx.lifecycle.LiveData
import com.example.themealapp.background.datasource.MealDatasource
import com.example.themealapp.background.response.CategoriesResponse

class MealRepository(private val mDataSource: MealDatasource) {

    val mCategories: LiveData<CategoriesResponse> = mDataSource.mCategories

    fun getCategories(){
        mDataSource.getCategories()
    }

}