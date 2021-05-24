package com.example.taskplanner.repository.model.dao

import androidx.room.*
import com.example.taskplanner.repository.model.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE id = :id ")
    fun findById(id: String): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(task: Task)

    @Delete
    fun delete(task: Task)


}