package com.softdevandre.movieapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.softdevandre.movieapi.databinding.MovieItemBinding

class MovieItemAdapter (private val context: Context, private val dataset: List<Movies>) :
    RecyclerView.Adapter<MovieItemAdapter.MovieViewHolder>() {

    class MovieViewHolder(binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textViewName: TextView = binding.tvMovieName
        val textViewYear: TextView = binding.tvMovieYear
        val imageView: ImageView = binding.ivMovie
        val materialCard: MaterialCardView = binding.mcvMovie
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        // create new view
        val adapterLayout =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = dataset[position]
        holder.textViewName.text = context.resources.getString(item.movieName)
        holder.textViewYear.text = context.resources.getString(item.movieYear)
        holder.imageView.setImageResource(item.movieImage)
//        holder.materialCard.setOnClickListener {
//            val intent = Intent(context, DetailCharacterActivity::class.java)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount() = dataset.size
}