package com.jegadeesan.apod.domain.usecase

import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.repository.ApodRepository
import com.jegadeesan.apod.data.util.DateTimeUtil.getCurrentDate
import com.jegadeesan.apod.data.util.DateTimeUtil.getDateBefore


class GetLatestApodListUseCase(private val apodRepository: ApodRepository?)
    : UseCase<Int, List<Apod>?>{

    override suspend fun execute(count: Int): List<Apod>? {
        val startDate = getDateBefore(count-1)
        val endDate = getCurrentDate()
        return apodRepository?.getApodFromSpecifiedDate(startDate, endDate, count = 30)
    }
}

