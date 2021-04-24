package com.jegadeesan.apod.data.repository

import android.util.Log
import com.jegadeesan.apod.data.mapper.toApodEntity
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
        val apod = apodLocalDataSource.getApod(date)
        return if(apod == null) {
            val apodApi = apodRemoteDataSource.getApod(date)
            apodLocalDataSource.saveApod(apodApi.toApodEntity())
            return apodApi
        } else {
            apod
        }
    }
}