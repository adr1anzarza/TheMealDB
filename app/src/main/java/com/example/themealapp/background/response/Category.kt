package com.example.themealapp.background.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(

    @Json(name = "idCategory")
    val idCategory: String? = "",

    @Json(name = "strCategory")
    val strCategory: String? = "",

    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String? = "",

    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String? = ""

) : Parcelable