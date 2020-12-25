package com.rudio.moviesdemo.presentation.utils

fun String.prependPosterPath(): String {
    return if (this.contains(BASE_URL_POSTER)) {
        this
    } else {
        BASE_URL_POSTER + this
    }
}

fun String.prependBackdropPath(): String {
    return if (this.contains(BASE_URL_BACKDROP)) {
        this
    } else {
        BASE_URL_BACKDROP + this
    }
}

fun String.prependCastPath(): String {
    return if (this.contains(BASE_URL_CAST)) {
        this
    } else {
        return BASE_URL_CAST + this
    }
}