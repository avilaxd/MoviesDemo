package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMoviesUseCase @Inject constructor (private val repositoryMovies: RepositoryMovies) {

    suspend operator fun invoke(apiKey: String) = repositoryMovies.getMovies(apiKey)
}