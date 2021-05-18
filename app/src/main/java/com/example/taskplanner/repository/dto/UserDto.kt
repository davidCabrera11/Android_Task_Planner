package com.example.taskplanner.repository.dto

data class UserDto(
    val id:String,
    val name:String,
    val passwordHash:String,
    val email:String,
    val profilePictureUrl:String,

)
