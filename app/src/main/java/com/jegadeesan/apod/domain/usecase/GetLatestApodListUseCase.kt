package com.jegadeesan.apod.domain.usecase

import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.repository.ApodRepository
import com.jegadeesan.apod.ui.util.DateTimeUtil.getCurrentDate
import com.jegadeesan.apod.ui.util.DateTimeUtil.getDateBefore
import java.text.SimpleDateFormat
import java.util.*


class GetLatestApodListUseCase(private val apodRepository: ApodRepository?)
    : UseCase<Int, List<Apod>?>{

    override suspend fun execute(count: Int): List<Apod>? {
        val startDate = getCurrentDate()
        val endDate = getDateBefore(count)
        return apodRepository?.getApodFromSpecifiedDate(startDate, endDate)
    }
}

