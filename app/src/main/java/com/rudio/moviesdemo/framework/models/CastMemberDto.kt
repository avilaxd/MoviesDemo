package com.rudio.moviesdemo.framework.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastMemberDto(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val nameActor: String = "",
    @Json(name = "character")
    val nameCharacter: String = "",
    @Json(name = "profile_path")
    val picture: String = ""
)