package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Backdrop(
    @Json(name = "width")
    val width: Int = 0,
    @Json(name = "height")
    val height: Int = 0,
    @Json(name = "file_path")
    val path: String = ""
) : Parcelable