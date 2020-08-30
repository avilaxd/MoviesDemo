package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.utils.Event
import com.rudio.moviesdemo.presentation.utils.prependPosterPath
import kotlinx.coroutines.launch

class ViewModelMovieDetail @ViewModelInject constructor(
    private val interactor: InteractorMovies
) : ViewModel() {
    private val movie: MutableLiveData<IMovie> = MutableLiveData()
    private val eventOnClickFavorite: MutableLiveData<Event<IMovie>> = MutableLiveData()
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    private val backdrops: MutableLiveData<List<IBackdrop>> = MutableLiveData()
    private val cast: MutableLiveData<List<ICastMember>> = MutableLiveData()

    fun getMovie(): LiveData<IMovie> = movie

    fun setMovie(movie: IMovie) { this.movie.value = movie }

    fun getEventOnClickFavorite(): LiveData<Event<IMovie>> = eventOnClickFavorite

    fun getBackdrops(): LiveData<List<IBackdrop>> = backdrops

    fun getCast(): LiveData<List<ICastMember>> = cast

    fun getIsFavorite(): LiveData<Boolean> = isFavorite

    fun insertFavorite(movie: IMovie) = viewModelScope.launch {
        interactor.insertFavoriteUseCase(movie)
        isFavorite.value = true
    }

    fun deleteFavorite(movie: IMovie) = viewModelScope.launch {
        interactor.deleteFavoriteUseCase(movie)
        isFavorite.value = false
    }

    fun fetchIsFavorite(id: Int) = viewModelScope.launch {
        isFavorite.value = interactor.isFavoriteUseCase(id) > 0
    }

    fun fetchBackdrops(id: Int, apiKey: String) = viewModelScope.launch {
        backdrops.value = interactor.getBackdropsUseCase(id, apiKey)
    }

    fun fetchCast(id: Int, apiKey: String) = viewModelScope.launch {
        cast.value = interactor.getCastUseCase(id, apiKey)
    }

    fun urlPoster(): String = movie.value?.poster?.prependPosterPath() ?: ""

    fun onClickFavorite() { eventOnClickFavorite.value =
        Event(movie.value!!)
    }
}