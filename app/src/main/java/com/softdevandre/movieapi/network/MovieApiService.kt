package com.softdevandre.movieapi.network

import com.softdevandre.movieapi.Constants.API_KEY
import com.softdevandre.movieapi.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MovieApiService {
    @GET("movie/popular?api_key=${API_KEY}")
    fun getPopularMovies(): Call<MovieResponse>

    @GET("movie/{movie_id}/credits?api_key=${API_KEY}")
    fun getMovieCredits(@Path("movie_id") movieId: Int): Call<CastResponse>
}

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}
