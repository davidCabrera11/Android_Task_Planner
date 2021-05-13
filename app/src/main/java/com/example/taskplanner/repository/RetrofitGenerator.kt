package com.example.taskplanner.repository

import com.example.taskplanner.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitGenerator {


    val retrofit: Retrofit by lazy{

        //Logs onto the console all the HTTP requests
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        if(BuildConfig.DEBUG){
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(0,TimeUnit.MILLISECONDS)
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES).build()
            builder.client(okHttpClient)
        }

        return@lazy retrofit



    }

}