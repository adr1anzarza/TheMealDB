package com.example.themealapp.mealbycategory.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MealsResponse(

    @SerializedName("meals")
    val meals: ArrayList<Meal>? = arrayListOf()

    ) : Serializable