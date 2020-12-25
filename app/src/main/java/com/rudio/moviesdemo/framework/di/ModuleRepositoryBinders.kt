package com.rudio.moviesdemo.framework.di

import com.rudio.moviesdemo.data.repositories.RepositoryMoviesImpl
import com.rudio.moviesdemo.domain.repositories.RepositoryMovies
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ModuleRepositoryBinders {

    @Singleton
    @Binds
    abstract fun bindRepositoryMovies(repositoryMovies: RepositoryMoviesImpl): RepositoryMovies
}