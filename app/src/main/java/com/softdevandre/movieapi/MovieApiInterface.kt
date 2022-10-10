package com.softdevandre.movieapi

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("movie/popular?api_key=4012a65332fcd3c790ca9ccb305e0a1b")
    fun getMoviesList(): Call<MovieResponse>
}