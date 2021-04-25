package com.jegadeesan.apod.data.repository

import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.data.mapper.toApodEntity
import com.jegadeesan.apod.data.repository.datasource.ApodLocalDataSource
import com.jegadeesan.apod.data.repository.datasource.ApodRemoteDataSource
import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.repository.ApodRepository

class ApodRepositoryImpl(private val apodLocalDataSource: ApodLocalDataSource,
                         private val apodRemoteDataSource: ApodRemoteDataSource): ApodRepository {

    override suspend fun getApodFromSpecifiedDate(startEnd: String, endDate: String): List<Apod> {
        val apod = apodLocalDataSource.getApodFromSpecifiedDate(startEnd, endDate)
        return if(apod == null) {
            val apodApiList = apodRemoteDataSource.getApodFromSpecifiedDate(startEnd, endDate)
            saveApodListInDb(apodApiList)
            return apodApiList
        } else {
            apod
        }
    }

    private suspend fun saveApodListInDb(apodApiList: List<Apod>) {
        val apodEntityList = arrayListOf<ApodEntity>()
        apodApiList.forEach { apodApi ->
            apodEntityList.add(apodApi.toApodEntity())
        }
        apodLocalDataSource.saveApodList(apodEntityList)
    }

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