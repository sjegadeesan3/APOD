package com.jegadeesan.apod.data.repository.datasourceImpl

import com.jegadeesan.apod.data.api.service.ApodService
import com.jegadeesan.apod.data.mapper.toApod
import com.jegadeesan.apod.data.repository.datasource.ApodRemoteDataSource
import com.jegadeesan.apod.domain.data.Apod

class ApodRemoteDataSourceImpl(private val apodService: ApodService) : ApodRemoteDataSource {

    override suspend fun getApod(date: String): Apod {
        return apodService.getApodByDate(date = date).body()?.toApod() ?: Apod()
    }

    override suspend fun getApodFromSpecifiedDate(startDate: String, endDate: String): List<Apod> {
        val apodList = arrayListOf<Apod>()
        val body = apodService.getApodList(
            startDate = startDate,
            endDate = endDate
        ).body()
        body?.let {
            it.forEach {
                apodList.add(it.toApod())
            }
        }
        return apodList
    }
}