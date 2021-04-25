package com.jegadeesan.apod.data.repository.datasourceImpl

import android.util.Log
import com.jegadeesan.apod.data.db.dao.ApodDao
import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.data.mapper.toApod
import com.jegadeesan.apod.data.repository.datasource.ApodLocalDataSource
import com.jegadeesan.apod.data.util.DateTimeUtil.convertStringToDate
import com.jegadeesan.apod.domain.data.Apod

class ApodLocalDataSourceImpl(private val apodDao: ApodDao) : ApodLocalDataSource {

    override suspend fun getApod(date: String): Apod? {
        return convertStringToDate(date)?.let {
            return apodDao.getApod(it)?.toApod()
        } ?: run {
            null
        }
    }

    override suspend fun saveApod(apodEntity: ApodEntity) {
        apodDao.saveApod(apodEntity)
    }

    override suspend fun saveApodList(apodEntity: List<ApodEntity>) {
        apodDao.saveApodList(apodEntity)
    }

    override suspend fun getApodFromSpecifiedDate(startDate: String, endDate: String): List<Apod>? {
        val fromDate = convertStringToDate(startDate)
        val toDate = convertStringToDate(endDate)

        if(fromDate != null && toDate != null) {
            val apodEntity = apodDao.getApod(fromDate)
            apodEntity?.let {
                val apodlist = arrayListOf<Apod>()
                val apodEntitylist = apodDao.getApodList(fromDate, toDate)
                apodEntitylist.forEach {
                    apodlist.add(it.toApod())
                }
                Log.d("ApodLocalDataSourceImpl", "count ${apodEntitylist.size}")
                return apodlist
            } ?: run {
                return null
            }
        } else {
            return null
        }

    }
}