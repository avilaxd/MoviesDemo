package com.rudio.moviesdemo.domain.repositories

import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface RepositoryMovies {

    suspend fun getMovies(apiKey: String): List<Movie>

    suspend fun getBackdrops(id: Int, apiKey: String): List<Backdrop>

    suspend fun getCast(id: Int, apiKey: String): List<CastMember>

    fun getFavorites(): Flow<List<Movie>>

    suspend fun insertFavorite(movie: Movie)

    suspend fun deleteFavorite(movie: Movie)

    suspend fun isFavorite(id: Int): Int
}