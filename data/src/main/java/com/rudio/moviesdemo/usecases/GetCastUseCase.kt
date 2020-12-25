package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCastUseCase @Inject constructor(private val repositoryMovies: RepositoryMovies) {

    suspend operator fun invoke(id: Int, apiKey: String) = repositoryMovies.getCast(id, apiKey)
}