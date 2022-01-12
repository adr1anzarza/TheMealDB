package com.example.themealapp.utils

import com.example.themealapp.BuildConfig
import com.example.themealapp.categories.background.response.CategoriesResponse
import com.example.themealapp.categories.background.response.RandomMealResponse
import com.example.themealapp.mealbycategory.background.response.MealDetailResponse
import com.example.themealapp.mealbycategory.background.response.MealsResponse
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import com.ihsanbal.logging.LoggingInterceptor
import com.ihsanbal.logging.Level
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

class WebService{
    companion object{
        fun services(): Retrofit {
            val okHttpClient: OkHttpClient
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

            okHttpClientBuilder.readTimeout(90, TimeUnit.SECONDS)
            okHttpClientBuilder.callTimeout(90, TimeUnit.SECONDS)
            okHttpClientBuilder.connectTimeout(90, TimeUnit.SECONDS)

            okHttpClientBuilder.addInterceptor(
                LoggingInterceptor.Builder()
                    .addHeader("Version", BuildConfig.VERSION_NAME)
                    .setLevel(Level.BASIC)
                    .setLevel(Level.HEADERS)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("Request")
                    .response("Response")
                    .build()
            )

            okHttpClient = okHttpClientBuilder.build()

            val retrofit: Retrofit
            val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            retrofitBuilder.client(okHttpClient)
            retrofitBuilder.baseUrl(BASE_URL)
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create(GsonUtils.gsonForDeserialization()))
            //retrofitBuilder.addCallAdapterFactory(CoroutineCallAdapterFactory())

            retrofit = retrofitBuilder.build()

            return retrofit
        }
    }
}

interface ServiceDefinition {

    @GET("categories.php")
    fun getCategoriesAsync(): Call<CategoriesResponse>

    @GET("filter.php")
    fun getCategoriesMeals(@Query("c") category: String): Call<MealsResponse>

    @GET("lookup.php")
    fun getMealDetail(@Query("i") id: String): Call<MealDetailResponse>

    @GET("random.php")
    fun getRandomMeal(): Call<RandomMealResponse>

    @GET("search.php")
    fun getMealByLetter(@Query("f") id: String): Call<MealDetailResponse>
}

object MealApi {
    val retrofitService : ServiceDefinition by lazy { WebService.services()
        .create(ServiceDefinition::class.java) }
}
