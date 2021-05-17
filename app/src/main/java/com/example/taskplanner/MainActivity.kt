package com.example.taskplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taskplanner.repository.RetrofitGenerator
import com.example.taskplanner.repository.auth.AuthService
import com.example.taskplanner.repository.dto.LoginDto
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var authService: AuthService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth()

    }

    private fun auth() {
        //val authService = RetrofitGenerator.retrofit.create(AuthService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = authService.auth(LoginDto("davidcab11@gmail.com","passw0rd"))
            if(response.isSuccessful){
                val tokenDto = response.body()
                Log.d("DEBUG", "tokenDto: $tokenDto")
            }else{
                response.errorBody()
            }

        }

     }
}