package com.carllewis.users.network

import android.util.Log
import com.carllewis.users.datamodels.Users
import com.carllewis.users.utils.USER_BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Call<List<Users>>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getRetrofitInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(USER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
            } else {

                Log.d("Retrofit Service", "Retrofit Service Error! ")
            }
            return retrofitService!!
        }
    }
}