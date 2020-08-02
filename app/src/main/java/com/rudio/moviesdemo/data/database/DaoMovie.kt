package com.rudio.moviesdemo.data.database

import androidx.room.*
import com.rudio.moviesdemo.data.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMovie {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movie: Movie)

    @Delete
    suspend fun deleteFavorite(movie: Movie)

    @Query("SELECT * FROM movie")
    fun getFavorites(): Flow<List<Movie>>

    @Query("SELECT count(*) FROM movie WHERE id = :id")
    suspend fun isFavorite(id: Int): Int
}