package com.carllewis.users.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carllewis.users.databinding.ItemMovieBinding
import com.carllewis.users.datamodels.Movies
import com.squareup.picasso.Picasso

class MovieAdpater: RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = mutableListOf<Movies>()

    fun setMovieList(movies: List<Movies>){
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = movies[position]

        holder.binding.movieTitle.text = movies.desc
        Picasso.get().load(movies.imageUrl).into(holder.binding.moviePoster)
        holder.binding.movieDesc.text = movies.name

    }

    override fun getItemCount() = movies.size

}
class MovieViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){}

