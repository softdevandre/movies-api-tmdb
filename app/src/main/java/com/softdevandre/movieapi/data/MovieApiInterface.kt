package com.softdevandre.movieapi.data

import com.softdevandre.movieapi.model.CastResponse
import com.softdevandre.movieapi.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("movie/popular?api_key=4012a65332fcd3c790ca9ccb305e0a1b")
    fun getMoviesList(): Call<MovieResponse>

    @GET("movie/{movie_id}/credits?api_key=4012a65332fcd3c790ca9ccb305e0a1b")
    fun getCastList(
        @Path("movie_id")
        movieId: Int?
    ): Call<CastResponse>
}