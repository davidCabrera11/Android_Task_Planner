package com.example.taskplanner.repository.remote.dto

import java.io.Serializable

data class TaskDto(
    val id: String,
    val description: String,
    val personResponsible:String,
    val dueDate: String,
    val status: String,
    val userId: String):Serializable
