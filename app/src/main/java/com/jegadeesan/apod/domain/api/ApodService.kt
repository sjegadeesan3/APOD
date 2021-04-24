package com.jegadeesan.apod.domain.api

import com.jegadeesan.apod.BuildConfig
import com.jegadeesan.apod.domain.data.ApodItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodService {

    @GET("planetary/apod")
    fun getApodList(@Query("api_key") apiKey : String = BuildConfig.API_KEY,
                    @Query("thumbs") thumbs: Boolean = true,
                    @Query("start_date") startDate: String,
                    @Query("end_date") endDate: String): List<ApodItem>

    @GET("planetary/apod")
    fun getApodByDate(@Query("api_key") apiKey : String = BuildConfig.API_KEY,
                @Query("thumbs") thumbs: Boolean = true,
                @Query("date") date: String): ApodItem
}

