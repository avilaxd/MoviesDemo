package com.rudio.moviesdemo.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rudio.moviesdemo.data.models.Movie

@Dao
interface DaoMovie {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movie: Movie)

    @Delete
    suspend fun deleteFavorite(movie: Movie)

    @Query("SELECT * FROM movie")
    fun getFavorites(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun isFavorite(id: Int): List<Movie>
}