package com.rudio.moviesdemo.framework.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDto(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "vote_average")
    val votesAverage: Double = 0.0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "release_date")
    val date: String = "",
    @Json(name = "original_language")
    val language: String = "",
    @Json(name = "overview")
    val overview: String = "",
    @Json(name = "poster_path")
    val poster: String = ""
)