package com.example.taskplanner.repository.model.dao

import androidx.room.*
import com.example.taskplanner.repository.model.entity.Task
import com.example.taskplanner.repository.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id ")
    fun findById(id: String): User

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun save(user: User)

    @Delete
    fun delete(user: User)



}