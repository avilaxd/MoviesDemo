package com.rudio.moviesdemo.framework.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "vote_average")
    val votesAverage: Double = 0.0,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "release_date")
    val date: String = "",
    @ColumnInfo(name = "original_language")
    val language: String = "",
    @ColumnInfo(name = "overview")
    val overview: String = "",
    @ColumnInfo(name = "poster_path")
    val poster: String = ""
)