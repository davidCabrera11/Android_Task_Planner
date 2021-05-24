package com.example.taskplanner.repository.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid:Int,
    val id:String,
    val name:String,
    val password:String,
    val email:String,
    val profilePictureUrl:String,



    )
