package com.softdevandre.movieapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent
        val movieTitle = intent.getStringExtra("title")
        val movieDate = intent.getStringExtra("release")
        val moviePoster = intent.getStringExtra("poster")
        binding.tvMovieTitle.text = movieTitle
        binding.tvMovieReleaseDate.text = movieDate
        Glide.with(this).load(moviePoster).into(binding.ivMovie)
    }
}

