package com.example.themealapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.themealapp.R
import com.example.themealapp.categories.background.response.Category
import com.example.themealapp.categories.ui.CategoryGridAdapter
import com.example.themealapp.mealbycategory.background.response.Meal
import com.example.themealapp.mealbycategory.background.response.MealsResponse
import com.example.themealapp.mealbycategory.ui.MealsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<Category>?) {
    val adapter = recyclerView.adapter as CategoryGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
                .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
                .into(imgView)
    }
}


@BindingAdapter("categoryLabel")
fun categoryLabel(textView: TextView, label: String?) {
    label?.let {
        textView.text = label ?: ""
    }
}

@BindingAdapter("listMeals")
fun listMeals(recyclerView: RecyclerView, mMealsList: LiveData<MealsResponse>?) {
    val adapter = recyclerView.adapter as MealsAdapter
    if (mMealsList != null) {
        adapter.submitList(mMealsList.value?.meals)
    }
}

@BindingAdapter("imageUrlMeal")
fun imageUrlMeal(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("categoryLabelMeal")
fun categoryLabelMeal(textView: TextView, label: String?) {
    label?.let {
        textView.text = label ?: ""
    }
}
