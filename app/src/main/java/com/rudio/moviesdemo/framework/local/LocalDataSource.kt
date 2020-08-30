package com.rudio.moviesdemo.framework.local

import com.rudio.moviesdemo.data.local.ILocalDataSource
import com.rudio.moviesdemo.presentation.models.Movie
import com.rudio.moviesdemo.domain.models.IMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor (
    private val daoMovie: DaoMovie
) : ILocalDataSource {

    override fun getFavorites(): Flow<List<IMovie>> = daoMovie.getFavorites()

    override suspend fun insertFavorite(movie: IMovie) = daoMovie.insertFavorite(movie as Movie)

    override suspend fun deleteFavorite(movie: IMovie) = daoMovie.deleteFavorite(movie as Movie)

    override suspend fun isFavorite(id: Int): Int = daoMovie.isFavorite(id)
}