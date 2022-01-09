package com.example.themealapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themealapp.background.datasource.MealDatasource
import com.example.themealapp.background.repository.MealRepository

class MainActivityViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                mRepository = MealRepository(
                    mDataSource = MealDatasource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}