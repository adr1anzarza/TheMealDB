package com.example.themealapp.mealbycategory.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Meal(

    @SerializedName("strMeal")
    val strMeal: String? = "",

    @SerializedName("strMealThumb")
    val strMealThumb: String? = "",

    @SerializedName("idMeal")
    val idMeal: String? = "",

) : Serializable