package com.rudio.moviesdemo.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieUi(
    val id: Int = 0,
    val votesAverage: Double = 0.0,
    val title: String = "",
    val date: String = "",
    val language: String = "",
    val overview: String = "",
    val poster: String = ""
) :  Parcelable