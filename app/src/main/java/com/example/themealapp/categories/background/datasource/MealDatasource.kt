package com.example.themealapp.categories.background.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themealapp.utils.MealApi
import com.example.themealapp.categories.background.response.CategoriesResponse
import com.example.themealapp.categories.background.response.RandomMealResponse
import com.example.themealapp.mealbycategory.background.response.MealDetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealDatasource {

    private val _categories = MutableLiveData<CategoriesResponse>()
    val mCategories: LiveData<CategoriesResponse> = _categories

    private val _randomMeals = MutableLiveData<RandomMealResponse>()
    val mRandomMealResponse: LiveData<RandomMealResponse> = _randomMeals

    private val _mealsByLetter = MutableLiveData<MealDetailResponse>()
    val mMealsByLetter: LiveData<MealDetailResponse> = _mealsByLetter

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

    fun getRandomMeal() {
        CoroutineScope(Dispatchers.Default).launch {
            val call: Call<RandomMealResponse> = MealApi.retrofitService.getRandomMeal()

            call.enqueue(object : Callback<RandomMealResponse> {
                override fun onResponse(call: Call<RandomMealResponse>?, response: Response<RandomMealResponse>) {
                    if (!response.isSuccessful) {
                        return
                    }
                    _randomMeals.value = response.body()
                }

                override fun onFailure(call: Call<RandomMealResponse>, t: Throwable) { }
            })

        }
    }

    fun getMealsByLetter(letter: String) {
        CoroutineScope(Dispatchers.Default).launch {
            val call: Call<MealDetailResponse> = MealApi.retrofitService.getMealByLetter(letter)

            call.enqueue(object : Callback<MealDetailResponse> {
                override fun onResponse(call: Call<MealDetailResponse>?, response: Response<MealDetailResponse>) {
                    if (!response.isSuccessful) {
                        return
                    }
                    _mealsByLetter.value = response.body()
                }

                override fun onFailure(call: Call<MealDetailResponse>, t: Throwable) { }
            })

        }
    }

}