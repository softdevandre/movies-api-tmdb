package com.softdevandre.movieapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softdevandre.movieapi.network.Cast
import com.softdevandre.movieapi.network.CastResponse
import com.softdevandre.movieapi.network.Movie
import com.softdevandre.movieapi.network.MovieApi
import com.softdevandre.movieapi.network.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class MovieApiStatus { LOADING, ERROR, DONE }

class MovieViewModel : ViewModel() {

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> = _status

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private val _cast = MutableLiveData<List<Cast>>()
    val cast: LiveData<List<Cast>> = _cast

    init {
        getMovies()
    }

    private fun getMovies() {
        _status.value = MovieApiStatus.LOADING
        try {
            MovieApi.retrofitService.getPopularMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>, response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        _status.value = MovieApiStatus.DONE
                        _movies.value = response.body()?.results

                    } else {
                        _status.value = MovieApiStatus.ERROR
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    _status.value = MovieApiStatus.ERROR
                }
            })
        } catch (e: Exception) {
            _status.value = MovieApiStatus.ERROR
            _movies.value = listOf()
        }
    }

    fun getMovie(movieId: Int) {
        _status.value = MovieApiStatus.LOADING
        try {
            MovieApi.retrofitService.getMovieCredits(movieId)
                .enqueue(object : Callback<CastResponse> {
                    override fun onResponse(
                        call: Call<CastResponse>, response: Response<CastResponse>
                    ) {
                        if (response.isSuccessful) {
                            _status.value = MovieApiStatus.DONE
                            _cast.value = response.body()?.cast
                        } else {
                            _status.value = MovieApiStatus.ERROR
                        }
                    }

                    override fun onFailure(call: Call<CastResponse>, t: Throwable) {
                        _status.value = MovieApiStatus.ERROR
                    }

                })
        } catch (e: Exception) {
            _status.value = MovieApiStatus.ERROR
            _cast.value = listOf()
        }
    }


    fun onMovieClicked(movie: Movie) {
        _movie.value = movie
    }
}

