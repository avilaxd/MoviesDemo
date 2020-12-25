package com.rudio.moviesdemo.framework.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseMovies(
    @Json(name = "page")
    val page: Int = 0,
    @Json(name = "total_results")
    val resultsTotal: Int = 0,
    @Json(name = "total_pages")
    val pagesTotal: Int = 0,
    @Json(name = "results")
    val movies: List<MovieDto> = listOf()
)