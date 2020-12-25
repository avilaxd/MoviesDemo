package com.rudio.moviesdemo.framework.mappers

import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.framework.models.MovieEntity
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import javax.inject.Inject

class MovieEntityMapper @Inject constructor() : ModelMapper<Movie, MovieEntity> {

    override fun mapToDomain(outerLayerModel: MovieEntity): Movie {
        return Movie(
            id = outerLayerModel.id,
            votesAverage = outerLayerModel.votesAverage,
            title = outerLayerModel.title,
            date = outerLayerModel.date,
            language = outerLayerModel.language,
            overview = outerLayerModel.overview,
            poster = outerLayerModel.poster
        )
    }

    override fun mapToOuter(domainModel: Movie): MovieEntity {
        return MovieEntity(
            id = domainModel.id,
            votesAverage = domainModel.votesAverage,
            title = domainModel.title,
            date = domainModel.date,
            language = domainModel.language,
            overview = domainModel.overview,
            poster = domainModel.poster
        )
    }
}