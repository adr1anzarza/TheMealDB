package com.example.themealapp.mealbycategory.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MealDetail (

    @SerializedName("idMeal")
    val idMeal: String? = "",

    @SerializedName("strMeal")
    val strMeal: String? = "",

    @SerializedName("strCategory")
    val strCategory: String? = "",

    @SerializedName("strArea")
    val strArea: String? = "",

    @SerializedName("strInstructions")
    val strInstructions: String? = "",

    @SerializedName("strMealThumb")
    val strMealThumb: String? = "",

) : Serializable