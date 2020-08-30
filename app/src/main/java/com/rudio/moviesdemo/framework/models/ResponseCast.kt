package com.rudio.moviesdemo.framework.models

import android.os.Parcelable
import com.rudio.moviesdemo.presentation.models.CastMember
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ResponseCast(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "cast")
    val cast: List<CastMember> = listOf()
) : Parcelable