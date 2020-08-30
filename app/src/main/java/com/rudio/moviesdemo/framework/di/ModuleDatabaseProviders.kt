package com.rudio.moviesdemo.framework.di

import android.content.Context
import androidx.room.Room
import com.rudio.moviesdemo.framework.local.DaoMovie
import com.rudio.moviesdemo.framework.local.DatabaseMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ModuleDatabaseProviders {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseMovies {
        return Room.databaseBuilder(
            context,
            DatabaseMovies::class.java,
            "database_movies").build()
    }

    @Singleton
    @Provides
    fun provideDaoMovie(databaseMovies: DatabaseMovies): DaoMovie {
        return databaseMovies.daoMovie()
    }
}