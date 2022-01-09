package com.example.themealapp.background.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themealapp.background.MealApi
import com.example.themealapp.background.response.CategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

class MealDatasource {

    private val _categories = MutableLiveData<CategoriesResponse>()
    val mCategories: LiveData<CategoriesResponse> = _categories

    fun getCategories(){
        CoroutineScope(Dispatchers.Default).launch {
            val getCategoriesDeferred = MealApi.retrofitService.getCategoriesAsync()
            try {
                val listResult = getCategoriesDeferred.await()
                _categories.value = listResult
            } catch (e: Exception){
                _categories.postValue(CategoriesResponse())
            }
        }
    }

}