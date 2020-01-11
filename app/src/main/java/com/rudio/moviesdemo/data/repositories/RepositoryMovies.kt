package com.rudio.moviesdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rudio.moviesdemo.data.models.*
import com.rudio.moviesdemo.utils.API_KEY
import com.rudio.moviesdemo.utils.ServiceTMDBHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepositoryMovies {
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    private val backdrops: MutableLiveData<List<Backdrop>> = MutableLiveData()
    private val cast: MutableLiveData<List<CastMember>> = MutableLiveData()

    fun getInstance() = this

    fun getMovies(): LiveData<List<Movie>> = movies

    fun getBackdrops(): LiveData<List<Backdrop>> = backdrops

    fun getCast(): LiveData<List<CastMember>> = cast

    fun fetchMovies() {
        ServiceTMDBHelper.getInstance().getMovies(API_KEY).enqueue(object : Callback<ResponseMovies> {
            override fun onResponse(call: Call<ResponseMovies>, response: Response<ResponseMovies>) {
                    movies.value = response.body()?.movies ?: listOf()
             }

            override fun onFailure(call: Call<ResponseMovies>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun fetchBackdrops(id: Int) {
        ServiceTMDBHelper.getInstance().getBackdrops(id, API_KEY).enqueue(object : Callback<ResponseBackdrops> {
            override fun onResponse(call: Call<ResponseBackdrops>, response: Response<ResponseBackdrops>) {
                backdrops.value = response.body()?.backdrops ?: listOf()
            }

            override fun onFailure(call: Call<ResponseBackdrops>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun fetchCast(id: Int) {
        ServiceTMDBHelper.getInstance().getCast(id, API_KEY).enqueue(object : Callback<ResponseCast> {
            override fun onResponse(call: Call<ResponseCast>, response: Response<ResponseCast>) {
                cast.value = response.body()?.cast ?: listOf()
            }

            override fun onFailure(call: Call<ResponseCast>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}