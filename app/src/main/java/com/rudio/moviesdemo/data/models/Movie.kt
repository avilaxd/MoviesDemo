package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int = 0,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val votesAverage: Float = 0F,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String = "",
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val date: String = "",
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val language: String = "en",
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String = "",
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val poster: String? = null
) : Parcelable