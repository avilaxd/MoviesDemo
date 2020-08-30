package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.domain.repositories.IRepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteFavoriteUseCase @Inject constructor(private val repositoryMovies: IRepositoryMovies) {

    suspend operator fun invoke(movie: IMovie) = repositoryMovies.deleteFavorite(movie)
}