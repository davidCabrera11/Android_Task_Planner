package com.example.taskplanner.repository.dto

import java.util.*

data class TaskDto(
    val id: String,
    val description: String,
    val personResponsible:String,
    val dueDate: String,
    val status: String,
    val userId: String

)
