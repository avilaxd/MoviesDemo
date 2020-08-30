package com.rudio.moviesdemo.data.remote

import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.domain.models.IMovie

interface IRemoteDataSource {

    suspend fun getMovies(apiKey: String): List<IMovie>

    suspend fun getBackdrops(id: Int, apiKey: String): List<IBackdrop>

    suspend fun getCast(id: Int, apiKey: String): List<ICastMember>
}