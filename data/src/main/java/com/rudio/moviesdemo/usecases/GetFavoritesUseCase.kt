package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFavoritesUseCase @Inject constructor(private val repositoryMovies: RepositoryMovies) {

    operator fun invoke() = repositoryMovies.getFavorites()
}