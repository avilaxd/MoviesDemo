package com.rudio.moviesdemo.presentation.interactors

import com.rudio.moviesdemo.usecases.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InteractorMovies @Inject constructor (
    val getMoviesUseCase: GetMoviesUseCase,
    val getBackdropsUseCase: GetBackdropsUseCase,
    val getCastUseCase: GetCastUseCase,
    val getFavoritesUseCase: GetFavoritesUseCase,
    val insertFavoriteUseCase: InsertFavoriteUseCase,
    val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    val isFavoriteUseCase: IsFavoriteUseCase
)