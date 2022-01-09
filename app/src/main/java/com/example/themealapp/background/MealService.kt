package com.example.themealapp.background

import com.example.themealapp.BuildConfig
import com.example.themealapp.background.response.CategoriesResponse
import com.example.themealapp.utils.GsonUtils
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import com.ihsanbal.logging.LoggingInterceptor
import com.ihsanbal.logging.Level
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
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
}

object MealApi {
    val retrofitService : ServiceDefinition by lazy { WebService.services().create(ServiceDefinition::class.java) }
}
