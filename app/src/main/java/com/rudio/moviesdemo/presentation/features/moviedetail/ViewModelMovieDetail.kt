package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.presentation.interactors.InteractorMovies
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import com.rudio.moviesdemo.presentation.models.BackdropUi
import com.rudio.moviesdemo.presentation.models.CastMemberUi
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.Event
import kotlinx.coroutines.launch

class ViewModelMovieDetail @ViewModelInject constructor(
    private val interactor: InteractorMovies,
    private val movieMapper: ModelMapper<Movie, MovieUi>,
    private val backdropMapper: ModelMapper<Backdrop, BackdropUi>,
    private val castMapper: ModelMapper<CastMember, CastMemberUi>
) : ViewModel() {
    private val movie: MutableLiveData<MovieUi> = MutableLiveData()
    private val eventOnClickFavorite: MutableLiveData<Event<MovieUi>> = MutableLiveData()
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    private val backdrops: MutableLiveData<List<BackdropUi>> = MutableLiveData()
    private val cast: MutableLiveData<List<CastMemberUi>> = MutableLiveData()

    fun getMovie(): LiveData<MovieUi> = movie

    fun setMovie(movie: MovieUi) { this.movie.value = movie }

    fun getEventOnClickFavorite(): LiveData<Event<MovieUi>> = eventOnClickFavorite

    fun getBackdrops(): LiveData<List<BackdropUi>> = backdrops

    fun getCast(): LiveData<List<CastMemberUi>> = cast

    fun getIsFavorite(): LiveData<Boolean> = isFavorite

    fun insertFavorite(movie: MovieUi) = viewModelScope.launch {
        interactor.insertFavoriteUseCase(movieMapper.mapToDomain(movie))
        isFavorite.value = true
    }

    fun deleteFavorite(movie: MovieUi) = viewModelScope.launch {
        interactor.deleteFavoriteUseCase(movieMapper.mapToDomain(movie))
        isFavorite.value = false
    }

    fun fetchIsFavorite(id: Int) = viewModelScope.launch {
        isFavorite.value = interactor.isFavoriteUseCase(id) > 0
    }

    fun fetchBackdrops(id: Int, apiKey: String) = viewModelScope.launch {
        backdrops.value = backdropMapper.mapToOuterList(interactor.getBackdropsUseCase(id, apiKey))
    }

    fun fetchCast(id: Int, apiKey: String) = viewModelScope.launch {
        cast.value = castMapper.mapToOuterList(interactor.getCastUseCase(id, apiKey))
    }

    fun onClickFavorite() { eventOnClickFavorite.value =
        Event(movie.value!!)
    }
}