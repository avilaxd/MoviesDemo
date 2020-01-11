package com.rudio.moviesdemo.interfaces

import com.rudio.moviesdemo.data.models.Movie

interface OnClickMovie {
    fun onClick(movie: Movie)
}