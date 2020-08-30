package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.IRepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IsFavoriteUseCase @Inject constructor(private val repositoryMovies: IRepositoryMovies) {

    suspend operator fun invoke(id: Int) = repositoryMovies.isFavorite(id)
}