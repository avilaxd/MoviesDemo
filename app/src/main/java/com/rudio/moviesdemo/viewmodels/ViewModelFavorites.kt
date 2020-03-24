package com.rudio.moviesdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFavorites @Inject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {

    fun getFavorites(): LiveData<List<Movie>> = repositoryMovies.getFavorites()

    fun deleteFavorite(movie: Movie) = repositoryMovies.deleteFavorite(movie)
}