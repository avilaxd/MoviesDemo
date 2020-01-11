package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCast(
    val id: Int = 0,
    val cast: List<CastMember> = listOf()
) : Parcelable