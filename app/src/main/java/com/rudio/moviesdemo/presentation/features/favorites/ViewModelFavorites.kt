package com.rudio.moviesdemo.presentation.features.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModelFavorites @ViewModelInject constructor(
    private val interactor: InteractorMovies,
    private val mapper: ModelMapper<Movie, MovieUi>
) : ViewModel() {
    private val favorites: MutableLiveData<List<MovieUi>> = MutableLiveData()
    private val eventOnClickMovie: MutableLiveData<Event<MovieUi>> = MutableLiveData()

    fun getFavorites(): LiveData<List<MovieUi>> = favorites

    fun deleteFavorite(movie: MovieUi) = viewModelScope.launch {
        interactor.deleteFavoriteUseCase(mapper.mapToDomain(movie))
    }

    fun fetchFavorites() = viewModelScope.launch {
        interactor.getFavoritesUseCase().collect {
            favorites.value = mapper.mapToOuterList(it)
        }
    }

    fun getEventOnClickMovie(): LiveData<Event<MovieUi>> = eventOnClickMovie

    fun onClickMovie(movie: MovieUi) {
        eventOnClickMovie.value =
            Event(movie)
    }
}