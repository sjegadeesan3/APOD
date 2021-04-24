package com.jegadeesan.apod.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jegadeesan.apod.data.db.dao.ApodDao
import com.jegadeesan.apod.data.db.entity.ApodEntity

@Database(entities = [ApodEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApodDatabase: RoomDatabase() {
    abstract fun apodDao(): ApodDao
}