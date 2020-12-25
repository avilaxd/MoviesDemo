package com.rudio.moviesdemo.framework.mappers

import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.framework.models.MovieDto
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import javax.inject.Inject

class MovieDtoMapper @Inject constructor() : ModelMapper<Movie, MovieDto> {

    override fun mapToDomain(outerLayerModel: MovieDto): Movie {
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

    override fun mapToOuter(domainModel: Movie): MovieDto {
        return MovieDto(
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