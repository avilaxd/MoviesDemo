package com.rudio.moviesdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rudio.moviesdemo.data.database.DaoMovie
import com.rudio.moviesdemo.data.models.*
import com.rudio.moviesdemo.networking.ServiceTMDB
import com.rudio.moviesdemo.utils.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    fun getMovies(): LiveData<List<Movie>> = movies

    fun getBackdrops(): LiveData<List<Backdrop>> = backdrops

    fun getCast(): LiveData<List<CastMember>> = cast

    fun getFavorites(): LiveData<List<Movie>> = daoMovies.getFavorites()

    fun insertFavorite(movie: Movie) = daoMovies.insertFavorite(movie)

    fun deleteFavorite(movie: Movie) = daoMovies.deleteFavorite(movie)

    fun isFavorite(id: Int) = daoMovies.isFavorite(id)

    fun fetchMovies() {
        serviceTMDB.getMovies(API_KEY).enqueue(object : Callback<ResponseMovies> {
            override fun onResponse(call: Call<ResponseMovies>, response: Response<ResponseMovies>) {
                    movies.value = response.body()?.movies ?: listOf()
             }

            override fun onFailure(call: Call<ResponseMovies>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun fetchBackdrops(id: Int) {
        serviceTMDB.getBackdrops(id, API_KEY).enqueue(object : Callback<ResponseBackdrops> {
            override fun onResponse(call: Call<ResponseBackdrops>, response: Response<ResponseBackdrops>) {
                backdrops.value = response.body()?.backdrops ?: listOf()
            }

            override fun onFailure(call: Call<ResponseBackdrops>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun fetchCast(id: Int) {
        serviceTMDB.getCast(id, API_KEY).enqueue(object : Callback<ResponseCast> {
            override fun onResponse(call: Call<ResponseCast>, response: Response<ResponseCast>) {
                cast.value = response.body()?.cast ?: listOf()
            }

            override fun onFailure(call: Call<ResponseCast>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}