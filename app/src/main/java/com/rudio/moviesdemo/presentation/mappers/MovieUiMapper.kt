package com.rudio.moviesdemo.presentation.mappers

import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.prependPosterPath
import javax.inject.Inject

class MovieUiMapper @Inject constructor() : ModelMapper<Movie, MovieUi> {

    override fun mapToDomain(outerLayerModel: MovieUi): Movie {
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

    override fun mapToOuter(domainModel: Movie): MovieUi {
        return MovieUi(
            id = domainModel.id,
            votesAverage = domainModel.votesAverage,
            title = domainModel.title,
            date = domainModel.date,
            language = domainModel.language,
            overview = domainModel.overview,
            poster = domainModel.poster.prependPosterPath()
        )
    }
}