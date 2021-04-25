package com.jegadeesan.apod.data.repository.datasource

import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.domain.data.Apod

interface ApodLocalDataSource {

    suspend fun getApod(date: String): Apod?

    suspend fun saveApod(apodEntity: ApodEntity)

    suspend fun saveApodList(apodEntity: List<ApodEntity>)

    suspend fun getApodFromSpecifiedDate(startDate: String, endDate: String, count: Int): List<Apod>?
}