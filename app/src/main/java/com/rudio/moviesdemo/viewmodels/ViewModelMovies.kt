package com.rudio.moviesdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelMovies @Inject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {

    fun getMovies() = repositoryMovies.getMovies()

    fun fetchMovies() = repositoryMovies.fetchMovies()
}