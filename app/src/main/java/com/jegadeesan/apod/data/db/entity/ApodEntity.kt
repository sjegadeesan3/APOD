package com.jegadeesan.apod.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "apod")
data class ApodEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val copyright: String? = null,
    val date: Date? = null,
    val explanation: String? = null,
    val hdUrl: String? = null,
    val mediaType: String? = null,
    val serviceVersion: String? = null,
    val thumbnailUrl: String? = null,
    val title: String? = null,
    val url: String? = null
)