package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseBackdrops(
    val id: Int = 0,
    val backdrops : List<Backdrop> = listOf()
) : Parcelable