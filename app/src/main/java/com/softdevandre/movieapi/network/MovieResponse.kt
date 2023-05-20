package com.softdevandre.movieapi.network

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    val results: List<Movie>
)

data class Movie(
     val id: Int,

    @SerializedName("title") val title: String?,

    @SerializedName("poster_path") val poster: String?,

    @SerializedName("release_date") val release: String?
)