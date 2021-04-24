package com.jegadeesan.apod.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apod")
data class ApodEntity (
    @PrimaryKey
    val id: String,
    val copyright: String? = null,
    val date: String? = null,
    val explanation: String? = null,
    val hdUrl: String? = null,
    val mediaType: String? = null,
    val serviceVersion: String? = null,
    val thumbnailUrl: String? = null,
    val title: String? = null,
    val url: String? = null
)