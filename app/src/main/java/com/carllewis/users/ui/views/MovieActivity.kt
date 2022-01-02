package com.carllewis.users.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.carllewis.users.R
import com.carllewis.users.databinding.ActivityMovieBinding
import com.carllewis.users.datamodels.MovieRepo
import com.carllewis.users.network.MovieRetrofitService
import com.carllewis.users.ui.adapters.MovieAdpater
import com.carllewis.users.ui.base.MovieViewModelFactory
import com.carllewis.users.ui.viewmodels.MovieViewModel

class MovieActivity : AppCompatActivity() {

    private val TAG = "Movie Activity"
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel
    private val movieRetrofitService = MovieRetrofitService.getRetrofitInstance()
    private val movieAdpater = MovieAdpater()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
        setupUI()
    }

    private fun setupUI() {
       binding.movieRecyclerView.adapter = movieAdpater
    }

    private fun setUpViewModel() {

        movieViewModel = ViewModelProvider(this, MovieViewModelFactory(MovieRepo(movieRetrofitService))).get(MovieViewModel::class.java)

        //On Success
        movieViewModel.movieList.observe(this, Observer {

            movieAdpater.setMovieList(it)
        })

        //OnError
        movieViewModel.errorMessage.observe(this, Observer {

        })

        //Get Movies
        movieViewModel.getAllMovies()
    }
}