package com.carllewis.users.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carllewis.users.datamodels.MovieRepo
import com.carllewis.users.datamodels.UserRepo
import com.carllewis.users.ui.viewmodels.MainViewModel
import com.carllewis.users.ui.viewmodels.MovieViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(private val userRepo: UserRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass){
        MainViewModel::class.java -> MainViewModel(userRepo)
        else -> throw IllegalArgumentException("Unknown ViewModel Class")
    } as T
}

