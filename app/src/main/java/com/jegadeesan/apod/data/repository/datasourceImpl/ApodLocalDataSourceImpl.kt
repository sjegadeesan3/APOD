package com.jegadeesan.apod.data.repository.datasourceImpl

import com.jegadeesan.apod.data.db.dao.ApodDao
import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.data.mapper.toApod
import com.jegadeesan.apod.data.repository.datasource.ApodLocalDataSource
import com.jegadeesan.apod.domain.data.Apod

class ApodLocalDataSourceImpl(private val apodDao: ApodDao) : ApodLocalDataSource {

    override suspend fun getApod(date: String): Apod? {
        return apodDao.getApod(date)?.toApod()
    }

    override suspend fun saveApod(apodEntity: ApodEntity) {
        apodDao.saveApod(apodEntity)
    }
}