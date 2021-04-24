package com.jegadeesan.apod.domain.usecase

import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.repository.ApodRepository

class GetApodByDateUseCase(private val apodRepository: ApodRepository?)
    : UseCase<String, Apod?>{

    override suspend fun execute(date: String): Apod? {
        return apodRepository?.getApod(date)
    }
}

