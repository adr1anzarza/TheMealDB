package com.example.themealapp.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoriesResponse(

    @SerializedName ("categories")
    val categories: ArrayList<Category>? = null

) : Serializable