package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsertFavoriteUseCase @Inject constructor(private val repositoryMovies: RepositoryMovies) {

    suspend operator fun invoke(movie: Movie) = repositoryMovies.insertFavorite(movie)
}