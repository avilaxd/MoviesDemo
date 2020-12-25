package com.rudio.moviesdemo.framework.local

import com.rudio.moviesdemo.data.local.LocalDataSource
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.framework.models.MovieEntity
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor (
    private val daoMovie: DaoMovie,
    private val mapper: ModelMapper<Movie, MovieEntity>
) : LocalDataSource {

    override fun getFavorites(): Flow<List<Movie>> {
        return daoMovie.getFavorites().map { mapper.mapToDomainList(it) }
    }

    override suspend fun insertFavorite(movie: Movie) {
        return daoMovie.insertFavorite(mapper.mapToOuter(movie))
    }

    override suspend fun deleteFavorite(movie: Movie) {
        return daoMovie.deleteFavorite(mapper.mapToOuter(movie))
    }

    override suspend fun isFavorite(id: Int): Int = daoMovie.isFavorite(id)
}