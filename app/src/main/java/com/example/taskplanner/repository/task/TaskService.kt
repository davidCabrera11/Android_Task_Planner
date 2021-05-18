package com.example.taskplanner.repository.task

import com.example.taskplanner.repository.dto.TaskDto
import com.example.taskplanner.repository.dto.UserDto
import retrofit2.Response
import retrofit2.http.*

interface TaskService {


    @POST("tasks")
    suspend fun createTask(@Body taskDto: TaskDto): Response<TaskDto>

    @GET("tasks")
    suspend fun getTasks(): Response<List<UserDto>>

    @GET("tasks/{id}")
    suspend fun findTaskById(@Path("id") id:String): Response<TaskDto>

    @PUT("tasks/{id}")
    suspend fun updateTask(@Path("id")id: String, @Body taskDto: TaskDto):Response<TaskDto>

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id:String): Response<TaskDto>



}