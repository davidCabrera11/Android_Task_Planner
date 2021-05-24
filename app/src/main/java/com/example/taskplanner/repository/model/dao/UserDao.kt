package com.example.taskplanner.repository.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taskplanner.repository.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id ")
    fun findUserId(id: String): User

    @Insert
    fun save(user: User)
}