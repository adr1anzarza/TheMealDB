package com.example.themealapp.categories.background.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoriesResponse(

    @SerializedName ("categories")
    val categories: ArrayList<Category>? = null

) : Serializable