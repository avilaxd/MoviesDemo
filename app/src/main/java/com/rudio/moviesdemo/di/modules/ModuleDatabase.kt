package com.rudio.moviesdemo.di.modules

import android.content.Context
import androidx.room.Room
import com.rudio.moviesdemo.data.database.DaoMovie
import com.rudio.moviesdemo.data.database.DatabaseMovies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDatabase {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): DatabaseMovies {
        return Room.databaseBuilder(
            context,
            DatabaseMovies::class.java,
            "database_movies").allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideDaoMovie(databaseMovies: DatabaseMovies): DaoMovie {
        return databaseMovies.daoMovie()
    }
}