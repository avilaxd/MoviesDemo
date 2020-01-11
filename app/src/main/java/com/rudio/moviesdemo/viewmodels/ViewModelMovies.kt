package com.rudio.moviesdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.repositories.RepositoryMovies

class ViewModelMovies(private val repositoryMovies: RepositoryMovies) : ViewModel() {

    fun getMovies() = repositoryMovies.getMovies()

    fun fetchMovies() = repositoryMovies.fetchMovies()
}