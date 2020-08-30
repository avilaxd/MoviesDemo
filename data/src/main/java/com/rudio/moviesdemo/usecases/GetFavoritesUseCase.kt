package com.rudio.moviesdemo.usecases

import com.rudio.moviesdemo.domain.repositories.IRepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFavoritesUseCase @Inject constructor(private val repositoryMovies: IRepositoryMovies) {

    operator fun invoke() = repositoryMovies.getFavorites()
}