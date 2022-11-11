package com.softdevandre.movieapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.data.MovieApiInterface
import com.softdevandre.movieapi.data.MovieApiService
import com.softdevandre.movieapi.databinding.FragmentDetailBinding
import com.softdevandre.movieapi.model.Cast
import com.softdevandre.movieapi.model.CastResponse
import com.softdevandre.movieapi.model.Movie
import com.softdevandre.movieapi.ui.DetailAdapter
import com.softdevandre.movieapi.ui.MovieListAdapter.Companion.IMAGE_BASE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : DialogFragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movie = Movie()
        binding.tvMovieTitle.text = movie.title
        binding.tvMovieReleaseDate.text = movie.release
        Glide.with(this).load(IMAGE_BASE + movie.poster).into(binding.ivMovie)
        recyclerView = binding.rvCast
        getCastData { cast: List<Cast> ->
            recyclerView.adapter = context?.let { DetailAdapter(it, cast) }
        }
    }

    private fun getCastData(callback: (List<Cast>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getCastList(null).enqueue(object : Callback<CastResponse> {
            override fun onResponse(call: Call<CastResponse>, response: Response<CastResponse>) {
                return callback(response.body()!!.cast)
            }

            override fun onFailure(call: Call<CastResponse>, t: Throwable) {

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}