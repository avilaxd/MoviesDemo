package com.rudio.moviesdemo.data.local

import com.rudio.moviesdemo.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getFavorites(): Flow<List<Movie>>

    suspend fun insertFavorite(movie: Movie)

    suspend fun deleteFavorite(movie: Movie)

    suspend fun isFavorite(id: Int): Int
}