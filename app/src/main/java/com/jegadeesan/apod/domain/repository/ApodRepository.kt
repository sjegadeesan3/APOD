package com.jegadeesan.apod.domain.repository

import com.jegadeesan.apod.domain.data.Apod

interface ApodRepository {
    suspend fun getApodFromSpecifiedDate(startDate: String, endDate: String): List<Apod>
    suspend fun getApod(date: String): Apod
}