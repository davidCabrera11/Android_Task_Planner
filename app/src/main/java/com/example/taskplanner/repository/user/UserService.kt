package com.example.taskplanner.repository.user

import com.example.taskplanner.repository.dto.UserDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserService {


    @POST("users")
    suspend fun createUser(@Body userDto: UserDto): Response<UserDto>

    @GET("users")
    suspend fun getUsers(): Response<List<UserDto>>

    @GET("users/{id}")
    suspend fun findUserById(@Path("id") id:String):Response<UserDto>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id")id: String, @Body userDto: UserDto):Response<UserDto>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id")id:String)

}