package com.rudio.moviesdemo.presentation.models

import android.os.Parcelable
import com.rudio.moviesdemo.domain.models.ICastMember
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CastMember(
    @Json(name = "id")
    override val id: Int = 0,
    @Json(name = "name")
    override val nameActor: String = "",
    @Json(name = "character")
    override val nameCharacter: String = "",
    @Json(name = "profile_path")
    override val picture: String = ""
) : ICastMember, Parcelable