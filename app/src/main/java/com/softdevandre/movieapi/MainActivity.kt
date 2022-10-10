package com.softdevandre.movieapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.softdevandre.movieapi.data.MovieApiInterface
import com.softdevandre.movieapi.data.MovieApiService
import com.softdevandre.movieapi.databinding.ActivityMainBinding
import com.softdevandre.movieapi.model.Movie
import com.softdevandre.movieapi.model.MovieResponse
import com.softdevandre.movieapi.ui.MovieItemAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.rvMovieList
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            recyclerView.adapter = MovieItemAdapter(this, movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMoviesList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
        })
    }
}