package com.example.retrofit2schoolmeal.di

import com.example.retrofit2schoolmeal.API.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        GsonConverterFactory.create() as Converter.Factory
    }

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }


        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                chain.proceed(request.build())
            }.build()
    }

    single { RxJava3CallAdapterFactory.create() as CallAdapter.Factory }

    single {
        Retrofit.Builder()
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .client(get())
            .baseUrl(" https://open.neis.go.kr/hub/mealServiceDietInfo")
            .build()
            .create(API::class.java)

    }
}