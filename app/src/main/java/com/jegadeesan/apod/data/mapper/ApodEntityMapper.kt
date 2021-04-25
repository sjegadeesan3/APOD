package com.jegadeesan.apod.data.mapper

import com.jegadeesan.apod.data.db.entity.ApodEntity
import com.jegadeesan.apod.data.util.DateTimeUtil.convertDateToString
import com.jegadeesan.apod.data.util.DateTimeUtil.convertStringToDate
import com.jegadeesan.apod.domain.data.Apod

fun ApodEntity.toApod(): Apod {
    return Apod(
        copyright = copyright,
        date = convertDateToString(date),
        explanation = explanation,
        hdUrl = hdUrl,
        mediaType = mediaType,
        serviceVersion = serviceVersion,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}

fun Apod.toApodEntity() : ApodEntity {
    return ApodEntity(
        copyright = copyright,
        date = convertStringToDate(date),
        explanation = explanation,
        hdUrl = hdUrl,
        mediaType = mediaType,
        serviceVersion = serviceVersion,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}