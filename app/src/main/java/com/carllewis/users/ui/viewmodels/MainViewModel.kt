package com.carllewis.users.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carllewis.users.datamodels.UserRepo
import com.carllewis.users.datamodels.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val userRepo: UserRepo): ViewModel() {

    val userList = MutableLiveData<List<Users>>()
    val errorMessage = MutableLiveData<String>()


    fun getAllUsers(){

        val response = userRepo.getAllUsers()
        response.enqueue(object: Callback<List<Users>> {

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {

               errorMessage.postValue(t.message)
            }


        })
    }

}