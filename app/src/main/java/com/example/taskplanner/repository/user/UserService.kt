package com.example.taskplanner.repository.user

import com.example.taskplanner.repository.dto.UserDto
import retrofit2.Response
import retrofit2.http.*

interface UserService {


    @POST
    suspend fun createUser(@Body userDto: UserDto): Response<UserDto>

    @GET
    suspend fun getUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun findUserById(@Path("id") id:String):Response<UserDto>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id")id: String, @Body userDto: UserDto):Response<UserDto>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id")id:String)

}