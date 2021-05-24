package com.example.taskplanner.repository.repository

import com.example.taskplanner.repository.model.dao.TaskDao
import com.example.taskplanner.repository.remote.task.TaskService
import javax.inject.Inject

class TaskRepository @Inject constructor(val taskService: TaskService, val  taskDao: TaskDao)