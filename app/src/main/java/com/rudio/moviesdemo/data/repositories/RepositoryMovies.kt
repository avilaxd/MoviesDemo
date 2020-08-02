package com.rudio.moviesdemo.data.repositories

import com.rudio.moviesdemo.data.database.DaoMovie
import com.rudio.moviesdemo.data.models.*
import com.rudio.moviesdemo.networking.ServiceTMDB
import com.rudio.moviesdemo.utils.API_KEY
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryMovies @Inject constructor(
    private val serviceTMDB: ServiceTMDB,
    private val daoMovies: DaoMovie
) {

    suspend fun getMovies() = serviceTMDB.getMovies(API_KEY)

    suspend fun getBackdrops(id: Int) = serviceTMDB.getBackdrops(id, API_KEY)

    suspend fun getCast(id: Int) = serviceTMDB.getCast(id, API_KEY)

    fun getFavorites() = daoMovies.getFavorites()

    suspend fun insertFavorite(movie: Movie) = daoMovies.insertFavorite(movie)

    suspend fun deleteFavorite(movie: Movie) = daoMovies.deleteFavorite(movie)

    suspend fun isFavorite(id: Int) = daoMovies.isFavorite(id)
}