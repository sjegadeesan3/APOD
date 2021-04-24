package com.jegadeesan.apod.ui.di

import com.jegadeesan.apod.ui.constants.AppConstants
import com.jegadeesan.apod.ui.constants.AppConstants.APP_BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }
}

private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(APP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

private fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .build()
}