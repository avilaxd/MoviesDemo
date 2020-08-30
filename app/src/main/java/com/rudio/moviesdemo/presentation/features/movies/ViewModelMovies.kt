package com.rudio.moviesdemo.presentation.features.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.utils.Event
import kotlinx.coroutines.launch


class ViewModelMovies @ViewModelInject constructor(
    private val interactor: InteractorMovies
) : ViewModel() {
    private val movies: MutableLiveData<List<IMovie>> = MutableLiveData()
    private val eventOnClickMovie: MutableLiveData<Event<IMovie>> = MutableLiveData()

    fun getMovies(): LiveData<List<IMovie>> = movies

    fun fetchMovies(apiKey: String) = viewModelScope.launch {
        movies.value = interactor.getMoviesUseCase(apiKey)
    }

    fun getEventOnClickMovie(): LiveData<Event<IMovie>> = eventOnClickMovie

    fun onClickMovie(movie: IMovie) {
        eventOnClickMovie.value =
            Event(movie)
    }
}