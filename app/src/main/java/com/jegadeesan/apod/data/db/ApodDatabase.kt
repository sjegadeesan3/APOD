package com.jegadeesan.apod.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jegadeesan.apod.data.db.dao.ApodDao

@Database(entities = [ApodDao::class],
    version = 1,
    exportSchema = false
)
abstract class ApodDatabase: RoomDatabase() {
    abstract fun apodDao(): ApodDao
}