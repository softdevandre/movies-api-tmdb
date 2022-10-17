package com.softdevandre.movieapi.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.DetailActivity
import com.softdevandre.movieapi.databinding.MovieItemBinding
import com.softdevandre.movieapi.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieItemAdapter(private val context: Context, private val dataset: List<Movie>) :
    RecyclerView.Adapter<MovieItemAdapter.MovieViewHolder>() {

    class MovieViewHolder(binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val movieTitle: TextView = binding.tvMovieTitle
        val movieDate: TextView = binding.tvMovieReleaseDate
        val moviePoster: ImageView = binding.ivMovie
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = dataset[position]
        Glide.with(holder.itemView.context)
            .load(IMAGE_BASE + item.poster)
            .into(holder.moviePoster)
        holder.movieTitle.text = item.title
        holder.movieDate.text = item.release
        holder.itemView.mcvMovie.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("release", item.release)
            intent.putExtra("poster", IMAGE_BASE + item.poster)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size

    companion object {
        const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    }
}