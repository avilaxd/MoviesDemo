package com.rudio.moviesdemo.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rudio.moviesdemo.data.models.Movie

@Dao
interface DaoMovie {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(movie: Movie)

    @Delete
    fun deleteFavorite(movie: Movie)

    @Query("SELECT * FROM movie")
    fun getFavorites(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun isFavorite(id: Int): List<Movie>
}