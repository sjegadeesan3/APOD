package com.jegadeesan.apod.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jegadeesan.apod.data.db.dao.ApodDao
import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.data.mapper.Converters

@Database(entities = [ApodEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ApodDatabase: RoomDatabase() {
    abstract fun apodDao(): ApodDao
}