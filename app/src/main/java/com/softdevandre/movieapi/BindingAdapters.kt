package com.softdevandre.movieapi

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.Constants.IMAGE_BASE
import com.softdevandre.movieapi.network.Cast
import com.softdevandre.movieapi.network.Movie
import com.softdevandre.movieapi.ui.MovieApiStatus
import com.softdevandre.movieapi.ui.MovieDetailAdapter
import com.softdevandre.movieapi.ui.MovieListAdapter

@BindingAdapter("movieImageUrl")
fun bindMovieImage(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(IMAGE_BASE + imgUrl).placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image).into(imgView)
}

@BindingAdapter("castImageUrl")
fun bindCastImage(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(IMAGE_BASE + imgUrl).placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image).into(imgView)
}

@BindingAdapter("movieListData")
fun bindMovieList(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MovieListAdapter
    adapter.submitList(data)
}

@BindingAdapter("castListData")
fun bindCastList(recyclerView: RecyclerView, data: List<Cast>?) {
    val adapter = recyclerView.adapter as MovieDetailAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: MovieApiStatus?) {
    when (status) {
        MovieApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        MovieApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }

        MovieApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

        else -> {
            statusImageView.visibility = View.GONE
        }
    }

}