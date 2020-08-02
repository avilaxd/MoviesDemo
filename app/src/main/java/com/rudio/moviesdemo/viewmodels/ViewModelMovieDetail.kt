package com.rudio.moviesdemo.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.utils.Event
import com.rudio.moviesdemo.utils.prependPosterPath
import kotlinx.coroutines.launch

class ViewModelMovieDetail @ViewModelInject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {
    private val movie: MutableLiveData<Movie> = MutableLiveData()
    private val eventOnClickFavorite: MutableLiveData<Event<Movie>> = MutableLiveData()
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    private val backdrops: MutableLiveData<List<Backdrop>> = MutableLiveData()
    private val cast: MutableLiveData<List<CastMember>> = MutableLiveData()

    fun getMovie(): LiveData<Movie> = movie

    fun setMovie(movie: Movie) { this.movie.value = movie }

    fun getEventOnClickFavorite(): LiveData<Event<Movie>> = eventOnClickFavorite

    fun getBackdrops(): LiveData<List<Backdrop>> = backdrops

    fun getCast(): LiveData<List<CastMember>> = cast

    fun getIsFavorite(): LiveData<Boolean> = isFavorite

    fun insertFavorite(movie: Movie) = viewModelScope.launch {
        repositoryMovies.insertFavorite(movie)
        isFavorite.value = true
    }

    fun deleteFavorite(movie: Movie) = viewModelScope.launch {
        repositoryMovies.deleteFavorite(movie)
        isFavorite.value = false
    }

    fun fetchIsFavorite(id: Int) = viewModelScope.launch {
        isFavorite.value = repositoryMovies.isFavorite(id) > 0
    }

    fun fetchBackdrops(id: Int) = viewModelScope.launch {
        backdrops.value = repositoryMovies.getBackdrops(id).backdrops
    }

    fun fetchCast(id: Int) = viewModelScope.launch {
        cast.value = repositoryMovies.getCast(id).cast
    }

    fun urlPoster(): String = movie.value?.poster?.prependPosterPath() ?: ""

    fun onClickFavorite() { eventOnClickFavorite.value = Event(movie.value!!) }
}