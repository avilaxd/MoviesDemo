package com.rudio.moviesdemo.framework.models

import android.os.Parcelable
import com.rudio.moviesdemo.presentation.models.Backdrop
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ResponseBackdrops(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "backdrops")
    val backdrops : List<Backdrop> = listOf()
) : Parcelable