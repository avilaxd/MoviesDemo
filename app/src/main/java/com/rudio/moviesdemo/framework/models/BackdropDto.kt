package com.rudio.moviesdemo.framework.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BackdropDto(
    @Json(name = "width")
    val width: Int = 0,
    @Json(name = "height")
    val height: Int = 0,
    @Json(name = "file_path")
    val path: String = ""
)