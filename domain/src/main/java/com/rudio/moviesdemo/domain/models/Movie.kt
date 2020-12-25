package com.rudio.moviesdemo.domain.models

data class Movie(
    val id: Int = 0,
    val votesAverage: Double = 0.0,
    val title: String = "",
    val date: String = "",
    val language: String = "",
    val overview: String = "",
    val poster: String = ""
)