package com.carllewis.users.datamodels

import com.carllewis.users.network.MovieRetrofitService

class MovieRepo(private val movieRetrofitService: MovieRetrofitService) {

    fun getAllMovies() = movieRetrofitService.getAllMovies()
}