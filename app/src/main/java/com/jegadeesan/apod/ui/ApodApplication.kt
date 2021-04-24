package com.jegadeesan.apod.ui

import android.app.Application
import com.jegadeesan.apod.ui.di.appModule
import com.jegadeesan.apod.ui.di.databaseModule
import com.jegadeesan.apod.ui.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApodApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApodApplication)
            modules(appModule, networkModule, databaseModule)
        }
    }
}