package com.rudio.moviesdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.utils.Event
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelMovies @Inject constructor(
    private val repositoryMovies: RepositoryMovies
) : ViewModel() {
    private val eventOnClickMovie: MutableLiveData<Event<Movie>> = MutableLiveData()

    fun getMovies() = repositoryMovies.getMovies()

    fun fetchMovies() = repositoryMovies.fetchMovies()

    fun getEventOnClickMovie(): LiveData<Event<Movie>> = eventOnClickMovie

    fun onClickMovie(movie: Movie) {
        eventOnClickMovie.value = Event(movie)
    }
}