package com.jegadeesan.apod.domain.repository

import com.jegadeesan.apod.domain.data.Apod

interface ApodRepository {
//    suspend fun getLast30DaysApodFromSpecifiedDate(startEnd: String, endDate: String): List<Apod>
    suspend fun getApod(date: String): Apod
}