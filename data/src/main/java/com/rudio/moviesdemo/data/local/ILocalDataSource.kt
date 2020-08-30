package com.rudio.moviesdemo.data.local

import com.rudio.moviesdemo.domain.models.IMovie
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {

    fun getFavorites(): Flow<List<IMovie>>

    suspend fun insertFavorite(movie: IMovie)

    suspend fun deleteFavorite(movie: IMovie)

    suspend fun isFavorite(id: Int): Int
}