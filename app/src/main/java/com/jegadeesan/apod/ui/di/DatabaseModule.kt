package com.jegadeesan.apod.ui.di

import androidx.room.Room
import com.jegadeesan.apod.data.db.ApodDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

class DatabaseModule {
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ApodDatabase::class.java,
            "apod-db",
        ).build()
    }

    single {
        get<ApodDatabase>().apodDao()
    }
}