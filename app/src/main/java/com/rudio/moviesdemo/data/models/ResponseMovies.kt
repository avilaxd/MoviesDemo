package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMovies(
    val page: Int = 0,
    @SerializedName("total_results")
    val resultsTotal: Int = 0,
    @SerializedName("total_pages")
    val pagesTotal: Int = 0,
    @SerializedName("results")
    val movies: List<Movie> = listOf()
) : Parcelable