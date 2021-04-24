package com.jegadeesan.apod.data.repository

import com.jegadeesan.apod.data.repository.datasource.ApodLocalDataSource
import com.jegadeesan.apod.data.repository.datasource.ApodRemoteDataSource
import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.repository.ApodRepository

class ApodRepositoryImpl(private val apodLocalDataSource: ApodLocalDataSource,
                         private val apodRemoteDataSource: ApodRemoteDataSource): ApodRepository {
//    override suspend fun getLast30DaysApodFromSpecifiedDate(startEnd: String, endDate: String): List<Apod> {
//        //ToDo: Implement
//    }

    override suspend fun getApod(date: String): Apod {
        return apodLocalDataSource.getApod(date)
            ?: apodRemoteDataSource.getApod(date)
    }
}