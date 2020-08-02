package com.rudio.moviesdemo.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModelFavorites @ViewModelInject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {
    private val favorites: MutableLiveData<List<Movie>> = MutableLiveData()
    private val eventOnClickMovie: MutableLiveData<Event<Movie>> = MutableLiveData()

    fun getFavorites(): LiveData<List<Movie>> = favorites

    fun deleteFavorite(movie: Movie) = viewModelScope.launch {
        repositoryMovies.deleteFavorite(movie)
    }

    fun fetchFavorites() = viewModelScope.launch {
        repositoryMovies.getFavorites().collect {
            favorites.value = it
        }
    }

    fun getEventOnClickMovie(): LiveData<Event<Movie>> = eventOnClickMovie

    fun onClickMovie(movie: Movie) {
        eventOnClickMovie.value = Event(movie)
    }
}