package com.rudio.moviesdemo.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.utils.Event
import com.rudio.moviesdemo.utils.prependPosterPath

class ViewModelMovieDetail @ViewModelInject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {
    private val movie: MutableLiveData<Movie> = MutableLiveData()
    private val eventOnClickFavorite: MutableLiveData<Event<Movie>> = MutableLiveData()

    fun getMovie(): LiveData<Movie> = movie

    fun setMovie(movie: Movie) { this.movie.value = movie }

    fun getEventOnClickFavorite(): LiveData<Event<Movie>> = eventOnClickFavorite

    fun getBackdrops(): LiveData<List<Backdrop>> = repositoryMovies.getBackdrops()

    fun insertFavorite(movie: Movie) = repositoryMovies.insertFavorite(movie)

    fun deleteFavorite(movie: Movie) = repositoryMovies.deleteFavorite(movie)

    fun isFavorite(id: Int) = repositoryMovies.isFavorite(id)

    fun fetchBackdrops(id: Int) = repositoryMovies.fetchBackdrops(id)

    fun getCast(): LiveData<List<CastMember>> = repositoryMovies.getCast()

    fun fetchCast(id: Int) = repositoryMovies.fetchCast(id)

    fun urlPoster(): String = movie.value?.poster?.prependPosterPath() ?: ""

    fun onClickFavorite() { eventOnClickFavorite.value = Event(movie.value!!) }
}