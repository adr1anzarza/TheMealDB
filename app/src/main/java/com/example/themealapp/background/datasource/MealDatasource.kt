package com.example.themealapp.background.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themealapp.background.MealApi
import com.example.themealapp.background.response.CategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealDatasource {

    private val _categories = MutableLiveData<CategoriesResponse>()
    val mCategories: LiveData<CategoriesResponse> = _categories

    fun getCategories() {
        CoroutineScope(Dispatchers.Default).launch {
            val call: Call<CategoriesResponse> = MealApi.retrofitService.getCategoriesAsync()

            call.enqueue(object : Callback<CategoriesResponse> {
                override fun onResponse(call: Call<CategoriesResponse>?, response: Response<CategoriesResponse>) {
                    if (!response.isSuccessful) {
                        return
                    }
                    _categories.value = response.body()
                }

                override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) { }
            })

        }
    }

}