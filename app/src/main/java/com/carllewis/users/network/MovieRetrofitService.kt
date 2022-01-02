package com.carllewis.users.network

import android.util.Log
import com.carllewis.users.datamodels.Movies
import com.carllewis.users.utils.MOVIE_BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieRetrofitService {

    @GET("/movielist.json")
    fun getAllMovies(): Call<List<Movies>>


    companion object {
        var movieRetrofitService: MovieRetrofitService? = null

        fun getRetrofitInstance(): MovieRetrofitService {
            if (movieRetrofitService == null){

                val retrofit = Retrofit.Builder()
                    .baseUrl(MOVIE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                movieRetrofitService = retrofit.create(MovieRetrofitService::class.java)
            } else {

                Log.d("Movie Retrofit Service", "Movie Retrofit Service Error! ")
            }
            return MovieRetrofitService.movieRetrofitService!!
        }

    }
}