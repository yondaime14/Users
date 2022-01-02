package com.carllewis.users.datamodels

import com.carllewis.users.network.RetrofitService

class UserRepo constructor(private val retrofitService: RetrofitService) {

    fun getAllUsers() = retrofitService.getUsers()
}