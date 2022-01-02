package com.carllewis.users.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carllewis.users.datamodels.MovieRepo
import com.carllewis.users.ui.viewmodels.MainViewModel
import com.carllewis.users.ui.viewmodels.MovieViewModel
import java.lang.IllegalArgumentException

class MovieViewModelFactory constructor(private val movieRepo: MovieRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass){
       MovieViewModel::class.java -> MovieViewModel(movieRepo)
        else -> throw IllegalArgumentException("Unknown ViewModel Class")
    } as T
}
