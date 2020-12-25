package com.rudio.moviesdemo.framework.di

import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.domain.models.Movie
import com.rudio.moviesdemo.framework.mappers.BackdropDtoMapper
import com.rudio.moviesdemo.framework.mappers.CastMemberDtoMapper
import com.rudio.moviesdemo.framework.mappers.MovieDtoMapper
import com.rudio.moviesdemo.framework.mappers.MovieEntityMapper
import com.rudio.moviesdemo.framework.models.BackdropDto
import com.rudio.moviesdemo.framework.models.CastMemberDto
import com.rudio.moviesdemo.framework.models.MovieDto
import com.rudio.moviesdemo.framework.models.MovieEntity
import com.rudio.moviesdemo.presentation.mappers.BackdropUiMapper
import com.rudio.moviesdemo.presentation.mappers.CastMemberUiMapper
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import com.rudio.moviesdemo.presentation.mappers.MovieUiMapper
import com.rudio.moviesdemo.presentation.models.BackdropUi
import com.rudio.moviesdemo.presentation.models.CastMemberUi
import com.rudio.moviesdemo.presentation.models.MovieUi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ModuleMappersBinders {

    @Singleton
    @Binds
    abstract fun bindMovieDtoMapper(mapper: MovieDtoMapper): ModelMapper<Movie, MovieDto>

    @Singleton
    @Binds
    abstract fun bindMovieEntityMapper(mapper: MovieEntityMapper): ModelMapper<Movie, MovieEntity>

    @Singleton
    @Binds
    abstract fun bindMovieUiMapper(mapper: MovieUiMapper): ModelMapper<Movie, MovieUi>

    @Singleton
    @Binds
    abstract fun bindBackdropDtoMapper(mapper: BackdropDtoMapper): ModelMapper<Backdrop, BackdropDto>

    @Singleton
    @Binds
    abstract fun bindBackdropUiMapper(mapper: BackdropUiMapper): ModelMapper<Backdrop, BackdropUi>

    @Singleton
    @Binds
    abstract fun bindCastDtoMapper(mapper: CastMemberDtoMapper): ModelMapper<CastMember, CastMemberDto>

    @Singleton
    @Binds
    abstract fun bindCastUiMapper(mapper: CastMemberUiMapper): ModelMapper<CastMember, CastMemberUi>
}