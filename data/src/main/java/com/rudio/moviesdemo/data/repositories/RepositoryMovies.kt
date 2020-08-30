package com.rudio.moviesdemo.data.repositories

import com.rudio.moviesdemo.data.local.ILocalDataSource
import com.rudio.moviesdemo.data.remote.IRemoteDataSource
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.domain.repositories.IRepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryMovies @Inject constructor(
    private val localDataSource: ILocalDataSource,
    private val remoteDataSource: IRemoteDataSource
) : IRepositoryMovies {

    override suspend fun getMovies(apiKey: String) = remoteDataSource.getMovies(apiKey)

    override suspend fun getBackdrops(id: Int, apiKey: String) = remoteDataSource.getBackdrops(id, apiKey)

    override suspend fun getCast(id: Int, apiKey: String) = remoteDataSource.getCast(id, apiKey)

    override fun getFavorites() = localDataSource.getFavorites()

    override suspend fun insertFavorite(movie: IMovie) = localDataSource.insertFavorite(movie)

    override suspend fun deleteFavorite(movie: IMovie) = localDataSource.deleteFavorite(movie)

    override suspend fun isFavorite(id: Int) = localDataSource.isFavorite(id)
}