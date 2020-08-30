package com.rudio.moviesdemo.framework.remote

import com.rudio.moviesdemo.data.remote.IRemoteDataSource
import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.domain.models.IMovie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val serviceTMDB: ServiceTMDB
) : IRemoteDataSource {

    override suspend fun getMovies(apiKey: String): List<IMovie> {
        return serviceTMDB.getMovies(apiKey).movies
    }

    override suspend fun getBackdrops(id: Int, apiKey: String): List<IBackdrop> {
        return serviceTMDB.getBackdrops(id, apiKey).backdrops
    }

    override suspend fun getCast(id: Int, apiKey: String): List<ICastMember> {
        return serviceTMDB.getCast(id, apiKey).cast
    }
}