package com.softdevandre.movieapi.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.DetailActivity
import com.softdevandre.movieapi.model.Movie
import com.softdevandre.movieapi.databinding.MovieItemBinding
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieItemAdapter(private val context: Context, private val dataset: List<Movie>) :
    RecyclerView.Adapter<MovieItemAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) = with(binding) {
            binding.tvMovieTitle.text = movie.title
            binding.tvMovieReleaseDate.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(binding.ivMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
        holder.itemView.mcvMovie.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Extras.MOVIE, item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size

    companion object {
        const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    }
}