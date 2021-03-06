package com.jegadeesan.apod.data.api.service

import com.jegadeesan.apod.BuildConfig
import com.jegadeesan.apod.data.api.data.ApodApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodService {

    @GET("planetary/apod")
    suspend fun getApodList(@Query("api_key") apiKey : String = BuildConfig.API_KEY,
                    @Query("thumbs") thumbs: Boolean = true,
                    @Query("start_date") startDate: String,
                    @Query("end_date") endDate: String): Response<List<ApodApi>>

    @GET("planetary/apod")
    suspend fun getApodByDate(@Query("api_key") apiKey : String = BuildConfig.API_KEY,
                @Query("thumbs") thumbs: Boolean = true,
                @Query("date") date: String): Response<ApodApi>
}

