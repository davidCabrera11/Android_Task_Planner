package com.example.taskplanner.repository.user

import com.example.taskplanner.repository.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users/{id}")
    suspend fun findUserById(@Path("id") id:String):Response<UserDto>

}