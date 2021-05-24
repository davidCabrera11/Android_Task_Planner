package com.example.taskplanner.repository.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.repository.remote.dto.UserDto

@Entity
data class Task(
    @PrimaryKey val uid:Int,
    val id: String,
    val description: String,
    val personResponsible:String,
    val dueDate: String,
    val status: String,
    val userId: String


){

    constructor(taskDto: TaskDto): this(
        0,
        taskDto.id,
        taskDto.description,
        taskDto.personResponsible,
        taskDto.dueDate,
        taskDto.status,
        taskDto.userId
    )

}
