package com.rudio.moviesdemo.framework.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseCast(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "cast")
    val cast: List<CastMemberDto> = listOf()
)