package com.rudio.moviesdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies

class ViewModelMovieDetail(private val repositoryMovies: RepositoryMovies) : ViewModel() {
    private val movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovie(): LiveData<Movie> = movie

    fun setMovie(movie: Movie) {
        this.movie.value = movie
    }

    fun getBackdrops(): LiveData<List<Backdrop>> = repositoryMovies.getBackdrops()

    fun fetchBackdrops(id: Int) = repositoryMovies.fetchBackdrops(id)

    fun getCast(): LiveData<List<CastMember>> = repositoryMovies.getCast()

    fun fetchCast(id: Int) = repositoryMovies.fetchCast(id)
}