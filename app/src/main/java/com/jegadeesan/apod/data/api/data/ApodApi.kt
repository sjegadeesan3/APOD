package com.jegadeesan.apod.domain.data
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ApodApi(
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("explanation")
    val explanation: String? = null,
    @SerializedName("hdurl")
    val hdUrl: String? = null,
    @SerializedName("media_type")
    val mediaType: String? = null,
    @SerializedName("service_version")
    val serviceVersion: String? = null,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
)