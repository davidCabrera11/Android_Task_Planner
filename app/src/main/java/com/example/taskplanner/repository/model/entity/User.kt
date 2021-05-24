package com.example.taskplanner.repository.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskplanner.repository.remote.dto.UserDto

@Entity
data class User(
    @PrimaryKey val uid:Int,
    val id:String,
    val name:String,
    val email:String,
    val profilePictureUrl:String,
){

    constructor(userDto: UserDto): this(
        0,
        userDto.id,
        userDto.name,
        userDto.email,
        userDto.profilePictureUrl
    )

}
