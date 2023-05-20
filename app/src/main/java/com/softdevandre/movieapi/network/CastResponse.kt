package com.softdevandre.movieapi.network

import com.google.gson.annotations.SerializedName


data class CastResponse(
    val id: Int, val cast: List<Cast>
)

data class Cast(
    val id: Int,

    @SerializedName("cast_id") val castId: Int,

    @SerializedName("credit_id") val creditId: String?,

    val name: String?,

    @SerializedName("profile_path") val picture: String?,

    val character: String?
)