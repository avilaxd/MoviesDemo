package com.rudio.moviesdemo.interfaces

import com.rudio.moviesdemo.data.models.Movie

interface OnDeleteMovie {
    fun onDelete(movie: Movie)
}