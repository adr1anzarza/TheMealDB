package com.example.themealapp.mealbycategory.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MealDetailResponse(

    @SerializedName("meals")
    val meals: ArrayList<MealDetail>? = arrayListOf()

) : Serializable