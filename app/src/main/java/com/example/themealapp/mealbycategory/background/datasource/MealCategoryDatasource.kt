package com.example.themealapp.mealbycategory.background.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themealapp.mealbycategory.background.response.MealsResponse
import com.example.themealapp.utils.MealApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealCategoryDatasource {

    private val _meals = MutableLiveData<MealsResponse>()
    val mMeals: LiveData<MealsResponse> = _meals

    fun getMeals(category: String) {
        CoroutineScope(Dispatchers.Default).launch {
            val call: Call<MealsResponse> = MealApi.retrofitService.getCategoriesMeals(category)

            call.enqueue(object : Callback<MealsResponse> {
                override fun onResponse(call: Call<MealsResponse>?, response: Response<MealsResponse>) {
                    if (!response.isSuccessful) {
                        return
                    }
                    _meals.value = response.body()
                }

                override fun onFailure(call: Call<MealsResponse>, t: Throwable) { }
            })

        }
    }

}