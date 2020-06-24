package com.rudio.moviesdemo.networking

import com.rudio.moviesdemo.data.models.ResponseBackdrops
import com.rudio.moviesdemo.data.models.ResponseCast
import com.rudio.moviesdemo.data.models.ResponseMovies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceTMDB {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String
    ): ResponseMovies

    @GET("movie/{movie_id}/images")
    suspend fun getBackdrops(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): ResponseBackdrops

    @GET("movie/{movie_id}/credits")
    suspend fun getCast(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): ResponseCast
}