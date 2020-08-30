package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.IRepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMoviesUseCase @Inject constructor (private val repositoryMovies: IRepositoryMovies) {

    suspend operator fun invoke(apiKey: String) = repositoryMovies.getMovies(apiKey)
}