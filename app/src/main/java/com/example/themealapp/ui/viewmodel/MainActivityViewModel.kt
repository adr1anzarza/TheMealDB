package com.example.themealapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.themealapp.background.repository.MealRepository

class MainActivityViewModel(private val mRepository: MealRepository): ViewModel() {

    init {
        getCategories()
    }

    private fun getCategories(){
        mRepository.getCategories()

    }

}