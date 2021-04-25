package com.jegadeesan.apod.ui.di

import com.jegadeesan.apod.data.api.service.ApodService
import com.jegadeesan.apod.data.repository.ApodRepositoryImpl
import com.jegadeesan.apod.data.repository.datasource.ApodLocalDataSource
import com.jegadeesan.apod.data.repository.datasource.ApodRemoteDataSource
import com.jegadeesan.apod.data.repository.datasourceImpl.ApodLocalDataSourceImpl
import com.jegadeesan.apod.data.repository.datasourceImpl.ApodRemoteDataSourceImpl
import com.jegadeesan.apod.domain.repository.ApodRepository
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import com.jegadeesan.apod.domain.usecase.GetLatestApodListUseCase
import com.jegadeesan.apod.ui.viewmodel.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    factory { GetApodByDateUseCase(get()) }
    factory { GetLatestApodListUseCase(get()) }
    factory<ApodRepository> { ApodRepositoryImpl(get(), get()) }
    factory<ApodRemoteDataSource> { ApodRemoteDataSourceImpl(get()) }
    factory<ApodLocalDataSource> { ApodLocalDataSourceImpl(get()) }

    single { get<Retrofit>().create(ApodService::class.java) }

    viewModel { ApodViewModel() }
}