package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.LoginActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

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