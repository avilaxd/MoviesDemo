package com.rudio.moviesdemo.presentation.features.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.Event
import kotlinx.coroutines.launch


class ViewModelMovies @ViewModelInject constructor(
    private val interactor: InteractorMovies,
    private val mapper: ModelMapper<Movie, MovieUi>
) : ViewModel() {
    private val movies: MutableLiveData<List<MovieUi>> = MutableLiveData()
    private val eventOnClickMovie: MutableLiveData<Event<MovieUi>> = MutableLiveData()

    fun getMovies(): LiveData<List<MovieUi>> = movies

    fun fetchMovies(apiKey: String) = viewModelScope.launch {
        movies.value = mapper.mapToOuterList(interactor.getMoviesUseCase(apiKey))
    }

    fun getEventOnClickMovie(): LiveData<Event<MovieUi>> = eventOnClickMovie

    fun onClickMovie(movie: MovieUi) {
        eventOnClickMovie.value =
            Event(movie)
    }
}