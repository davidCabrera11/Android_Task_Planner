package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.auth.AuthService
import com.example.taskplanner.repository.remote.dto.LoginDto
import com.example.taskplanner.storage.Storage
import com.example.taskplanner.viewmodel.LoginActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {


    val viewModel by viewModels<LoginActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel.successLiveData.observe(this, {success ->
            if (success){
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        })
        viewModel.auth()
    }



}