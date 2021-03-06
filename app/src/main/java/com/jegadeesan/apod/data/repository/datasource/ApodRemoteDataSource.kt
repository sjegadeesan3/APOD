package com.jegadeesan.apod.data.repository.datasource

import com.jegadeesan.apod.domain.data.Apod


interface ApodRemoteDataSource {

    suspend fun getApod(date: String): Apod
    suspend fun getApodFromSpecifiedDate(startDate: String, endDate: String): List<Apod>
}