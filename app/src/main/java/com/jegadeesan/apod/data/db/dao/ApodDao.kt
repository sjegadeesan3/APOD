package com.jegadeesan.apod.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jegadeesan.apod.data.db.entity.ApodEntity
import java.util.*

@Dao
interface ApodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveApodList(apodList: List<ApodEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveApod(apodList: ApodEntity)

    @Query("SELECT * FROM apod")
    suspend fun getAllApod(): List<ApodEntity>

    @Query("SELECT * FROM apod WHERE date BETWEEN :date AND :date LIMIT 1")
    suspend fun getApod(date: Date): ApodEntity?

    @Query("SELECT * FROM apod WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getApodList(startDate: Date, endDate: Date): List<ApodEntity>
}