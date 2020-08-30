package com.rudio.moviesdemo.domain.repositories

import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.domain.models.IMovie
import kotlinx.coroutines.flow.Flow

interface IRepositoryMovies {

    suspend fun getMovies(apiKey: String): List<IMovie>

    suspend fun getBackdrops(id: Int, apiKey: String): List<IBackdrop>

    suspend fun getCast(id: Int, apiKey: String): List<ICastMember>

    fun getFavorites(): Flow<List<IMovie>>

    suspend fun insertFavorite(movie: IMovie)

    suspend fun deleteFavorite(movie: IMovie)

    suspend fun isFavorite(id: Int): Int
}