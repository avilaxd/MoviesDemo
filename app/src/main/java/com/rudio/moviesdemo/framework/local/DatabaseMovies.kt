package com.rudio.moviesdemo.framework.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rudio.moviesdemo.framework.models.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class DatabaseMovies : RoomDatabase() {

    abstract fun daoMovie(): DaoMovie
}