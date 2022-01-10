package com.example.themealapp.categories.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RandomMealResponse(

    @SerializedName("meals")
    val meals: ArrayList<RandomMeal>? = arrayListOf()

) : Serializable