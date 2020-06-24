package com.rudio.moviesdemo.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.utils.Event
import kotlinx.coroutines.launch


class ViewModelMovies @ViewModelInject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {
    private val eventOnClickMovie: MutableLiveData<Event<Movie>> = MutableLiveData()

    fun getMovies() = repositoryMovies.getMovies()

    fun fetchMovies() = viewModelScope.launch { repositoryMovies.fetchMovies() }

    fun getEventOnClickMovie(): LiveData<Event<Movie>> = eventOnClickMovie

    fun onClickMovie(movie: Movie) {
        eventOnClickMovie.value = Event(movie)
    }
}