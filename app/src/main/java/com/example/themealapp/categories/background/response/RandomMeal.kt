package com.example.themealapp.categories.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RandomMeal (

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