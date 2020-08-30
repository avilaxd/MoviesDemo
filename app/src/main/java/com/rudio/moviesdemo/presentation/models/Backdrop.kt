package com.rudio.moviesdemo.presentation.models

import android.os.Parcelable
import com.rudio.moviesdemo.domain.models.IBackdrop
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Backdrop(
    @Json(name = "width")
    override val width: Int = 0,
    @Json(name = "height")
    override val height: Int = 0,
    @Json(name = "file_path")
    override val path: String = ""
) : IBackdrop, Parcelable