package com.rudio.moviesdemo.domain.models

interface IMovie {
    val id: Int
    val votesAverage: Double
    val title: String
    val date: String
    val language: String
    val overview: String
    val poster: String
}