package com.rudio.moviesdemo.data.repositories

import com.rudio.moviesdemo.data.local.LocalDataSource
import com.rudio.moviesdemo.data.remote.RemoteDataSource
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryMoviesImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : RepositoryMovies {

    override suspend fun getMovies(apiKey: String) = remoteDataSource.getMovies(apiKey)

    override suspend fun getBackdrops(id: Int, apiKey: String) = remoteDataSource.getBackdrops(id, apiKey)

    override suspend fun getCast(id: Int, apiKey: String) = remoteDataSource.getCast(id, apiKey)

    override fun getFavorites() = localDataSource.getFavorites()

    override suspend fun insertFavorite(movie: Movie) = localDataSource.insertFavorite(movie)

    override suspend fun deleteFavorite(movie: Movie) = localDataSource.deleteFavorite(movie)

    override suspend fun isFavorite(id: Int) = localDataSource.isFavorite(id)
}