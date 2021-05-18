package com.example.taskplanner.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taskplanner.R
import com.example.taskplanner.repository.auth.AuthService
import com.example.taskplanner.repository.dto.LoginDto
import com.example.taskplanner.repository.user.UserService
import com.example.taskplanner.storage.LocalStorage
import com.example.taskplanner.storage.Storage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var storage: Storage

    @Inject
    lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Developer","token ${storage.getToken()}")

        findUserById()


    }

    private fun findUserById(){
            GlobalScope.launch(Dispatchers.IO) {
                val response = userService.findUserById("60986fda6619f922895259c8")
                if(response.isSuccessful){
                    val user = response.body()!!
                    Log.d("DEBUG", "tokenDto: $user")
                }else{
                    response.errorBody()
                }

            }





    }


}