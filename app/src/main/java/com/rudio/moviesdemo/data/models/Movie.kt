package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int = 0,
    @SerializedName("vote_average")
    val votesAverage: Float = 0F,
    val title: String = "",
    @SerializedName("release_date")
    val date: String = "",
    @SerializedName("original_language")
    val language: String = "en",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("poster_path")
    val poster: String? = null
) : Parcelable