package com.example.themealapp.mealbycategory.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themealapp.mealbycategory.background.datasource.MealCategoryDatasource
import com.example.themealapp.mealbycategory.background.repository.MealsCategoryRepository

class MealsViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealsViewModel::class.java)) {
            return MealsViewModel(
                mRepository = MealsCategoryRepository(
                    mDataSource = MealCategoryDatasource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}