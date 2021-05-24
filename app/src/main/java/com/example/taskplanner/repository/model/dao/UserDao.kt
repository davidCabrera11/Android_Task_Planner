package com.example.taskplanner.repository.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taskplanner.repository.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun all(): List<User>

    @Query("SELECT 1 FROM user WHERE id = :id ")
    fun findUserId(id: String)

    @Insert
    fun save(user: User):User

}