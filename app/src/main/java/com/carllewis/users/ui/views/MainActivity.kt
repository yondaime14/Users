package com.carllewis.users.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carllewis.users.R
import com.carllewis.users.databinding.ActivityMainBinding
import com.carllewis.users.datamodels.UserRepo
import com.carllewis.users.network.RetrofitService
import com.carllewis.users.ui.adapters.UsersAdapter
import com.carllewis.users.ui.base.ViewModelFactory
import com.carllewis.users.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "Main Activity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainviewModel: MainViewModel
    private val retrofitService = RetrofitService.getRetrofitInstance()
    private val usersAdapter = UsersAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setupUI()
    }


    private fun setUpViewModel(){
        mainviewModel = ViewModelProvider(this, ViewModelFactory(UserRepo(retrofitService))).get(MainViewModel::class.java)

        mainviewModel.userList.observe(this, Observer {
            Log.d(TAG, "OnCreate $it")
            usersAdapter.setUserlist(it)
        })

        mainviewModel.errorMessage.observe(this, Observer {

        })

        mainviewModel.getAllUsers()

    }

    private fun setupUI(){

        binding.recyclerview.adapter = usersAdapter
        binding.recyclerview.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL))


        val fab: View = findViewById(R.id.movieFab)
        fab.setOnClickListener {view ->
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

    }
}