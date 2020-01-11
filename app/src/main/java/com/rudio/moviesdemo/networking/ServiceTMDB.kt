package com.rudio.moviesdemo.networking

import com.rudio.moviesdemo.data.models.ResponseBackdrops
import com.rudio.moviesdemo.data.models.ResponseCast
import com.rudio.moviesdemo.data.models.ResponseMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceTMDB {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Call<ResponseMovies>

    @GET("movie/{movie_id}/images")
    fun getBackdrops(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<ResponseBackdrops>

    @GET("movie/{movie_id}/credits")
    fun getCast(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<ResponseCast>
}