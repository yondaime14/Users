package com.carllewis.users.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carllewis.users.datamodels.MovieRepo
import com.carllewis.users.datamodels.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel constructor(private val movieRepo: MovieRepo): ViewModel() {

    val movieList = MutableLiveData<List<Movies>>()
    val errorMessage = MutableLiveData<String>()


    fun getAllMovies(){

        val response = movieRepo.getAllMovies()
        response.enqueue(object: Callback<List<Movies>> {

            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {

                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {

                errorMessage.postValue(t.message)
            }


        })
    }
}