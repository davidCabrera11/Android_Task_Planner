package com.example.taskplanner.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskplanner.repository.model.dao.TaskDao
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.Task
import com.example.taskplanner.repository.model.entity.User

@Database(entities = arrayOf(User::class, Task::class), version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao


}