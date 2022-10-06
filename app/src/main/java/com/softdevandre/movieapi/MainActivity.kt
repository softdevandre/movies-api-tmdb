package com.softdevandre.movieapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.softdevandre.movieapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myDataset = MoviesDatasource().loadMovies()

        val recyclerView = binding.rvMovieList
        recyclerView.adapter = MovieItemAdapter(this, myDataset)
    }
}