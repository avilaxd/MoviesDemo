package com.rudio.moviesdemo.framework.remote

import com.rudio.moviesdemo.data.remote.RemoteDataSource
import com.rudio.moviesdemo.domain.models.*
import com.rudio.moviesdemo.framework.models.BackdropDto
import com.rudio.moviesdemo.framework.models.CastMemberDto
import com.rudio.moviesdemo.framework.models.MovieDto
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val serviceTMDB: ServiceTMDB,
    private val movieMapper: ModelMapper<Movie, MovieDto>,
    private val backdropMapper: ModelMapper<Backdrop, BackdropDto>,
    private val castMapper: ModelMapper<CastMember, CastMemberDto>
) : RemoteDataSource {

    override suspend fun getMovies(apiKey: String): List<Movie> {
        return movieMapper.mapToDomainList(serviceTMDB.getMovies(apiKey).movies)
    }

    override suspend fun getBackdrops(id: Int, apiKey: String): List<Backdrop> {
        return backdropMapper.mapToDomainList(serviceTMDB.getBackdrops(id, apiKey).backdrops)
    }

    override suspend fun getCast(id: Int, apiKey: String): List<CastMember> {
        return castMapper.mapToDomainList(serviceTMDB.getCast(id, apiKey).cast)
    }
}