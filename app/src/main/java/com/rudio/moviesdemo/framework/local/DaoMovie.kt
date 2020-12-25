package com.rudio.moviesdemo.framework.local

import androidx.room.*
import com.rudio.moviesdemo.framework.models.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMovie {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movie: MovieEntity)

    @Delete
    suspend fun deleteFavorite(movie: MovieEntity)

    @Query("SELECT * FROM movies")
    fun getFavorites(): Flow<List<MovieEntity>>

    @Query("SELECT count(*) FROM movies WHERE id = :id")
    suspend fun isFavorite(id: Int): Int
}