package com.jegadeesan.apod.data.mapper

import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.data.api.data.ApodApi

fun ApodApi.toApod(): Apod {
    return Apod(
        copyright = copyright,
        date = date,
        explanation = explanation,
        hdUrl = hdUrl,
        mediaType = mediaType,
        serviceVersion = serviceVersion,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url,
    )
}