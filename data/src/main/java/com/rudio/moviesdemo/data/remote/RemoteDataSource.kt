package com.rudio.moviesdemo.data.remote

import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.domain.models.Movie

interface RemoteDataSource {

    suspend fun getMovies(apiKey: String): List<Movie>

    suspend fun getBackdrops(id: Int, apiKey: String): List<Backdrop>

    suspend fun getCast(id: Int, apiKey: String): List<CastMember>
}