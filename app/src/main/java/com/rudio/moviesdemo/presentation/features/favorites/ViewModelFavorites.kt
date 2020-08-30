package com.rudio.moviesdemo.presentation.features.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModelFavorites @ViewModelInject constructor(
    private val interactor: InteractorMovies
) : ViewModel() {
    private val favorites: MutableLiveData<List<IMovie>> = MutableLiveData()
    private val eventOnClickMovie: MutableLiveData<Event<IMovie>> = MutableLiveData()

    fun getFavorites(): LiveData<List<IMovie>> = favorites

    fun deleteFavorite(movie: IMovie) = viewModelScope.launch {
        interactor.deleteFavoriteUseCase(movie)
    }

    fun fetchFavorites() = viewModelScope.launch {
        interactor.getFavoritesUseCase().collect {
            favorites.value = it
        }
    }

    fun getEventOnClickMovie(): LiveData<Event<IMovie>> = eventOnClickMovie

    fun onClickMovie(movie: IMovie) {
        eventOnClickMovie.value =
            Event(movie)
    }
}