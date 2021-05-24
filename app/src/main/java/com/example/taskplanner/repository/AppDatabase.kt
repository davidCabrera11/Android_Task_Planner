package com.example.taskplanner.repository

import androidx.room.Database
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase {

    abstract fun userDao(): UserDao


}