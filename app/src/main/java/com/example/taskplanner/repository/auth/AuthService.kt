package com.example.taskplanner.repository.auth

import retrofit2.http.POST

interface AuthService {

    @POST("/auth")
    suspend fun auth(){


    }


}