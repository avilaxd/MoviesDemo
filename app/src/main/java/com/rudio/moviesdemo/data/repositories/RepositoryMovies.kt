package com.rudio.moviesdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rudio.moviesdemo.data.database.DaoMovie
import com.rudio.moviesdemo.data.models.*
import com.rudio.moviesdemo.networking.ServiceTMDB
import com.rudio.moviesdemo.utils.API_KEY
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryMovies @Inject constructor(
    private val serviceTMDB: ServiceTMDB,
    private val daoMovies: DaoMovie
) {
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    private val backdrops: MutableLiveData<List<Backdrop>> = MutableLiveData()
    private val cast: MutableLiveData<List<CastMember>> = MutableLiveData()
    private val favorites: LiveData<List<Movie>> = daoMovies.getFavorites()

    fun getMovies(): LiveData<List<Movie>> = movies

    fun getBackdrops(): LiveData<List<Backdrop>> = backdrops

    fun getCast(): LiveData<List<CastMember>> = cast

    fun getFavorites(): LiveData<List<Movie>> = favorites

    suspend fun insertFavorite(movie: Movie) = daoMovies.insertFavorite(movie)

    suspend fun deleteFavorite(movie: Movie) = daoMovies.deleteFavorite(movie)

    suspend fun isFavorite(id: Int) = daoMovies.isFavorite(id).isNotEmpty()

    suspend fun fetchMovies() {
        try {
            val response = serviceTMDB.getMovies(API_KEY)
            movies.value = response.movies
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }

    suspend fun fetchBackdrops(id: Int) {
        try {
            val response = serviceTMDB.getBackdrops(id, API_KEY)
            backdrops.value = response.backdrops
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }

    suspend fun fetchCast(id: Int) {
        try {
            val response = serviceTMDB.getCast(id, API_KEY)
            cast.value = response.cast
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }
}