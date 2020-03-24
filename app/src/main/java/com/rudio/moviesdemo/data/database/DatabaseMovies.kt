package com.rudio.moviesdemo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rudio.moviesdemo.data.models.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class DatabaseMovies : RoomDatabase() {

    abstract fun daoMovie(): DaoMovie
}