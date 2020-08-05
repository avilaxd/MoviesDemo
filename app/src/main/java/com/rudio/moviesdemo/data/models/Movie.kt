package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @Json(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "vote_average")
    @Json(name = "vote_average")
    val votesAverage: Double = 0.0,
    @ColumnInfo(name = "title")
    @Json(name = "title")
    val title: String = "",
    @ColumnInfo(name = "release_date")
    @Json(name = "release_date")
    val date: String = "",
    @ColumnInfo(name = "original_language")
    @Json(name = "original_language")
    val language: String = "",
    @ColumnInfo(name = "overview")
    @Json(name = "overview")
    val overview: String = "",
    @ColumnInfo(name = "poster_path")
    @Json(name = "poster_path")
    val poster: String = ""
) : Parcelable