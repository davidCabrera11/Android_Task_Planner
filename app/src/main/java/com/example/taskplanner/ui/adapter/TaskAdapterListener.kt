package com.example.taskplanner.ui.adapter

import com.example.taskplanner.repository.remote.dto.TaskDto

interface TaskAdapterListener {


    fun onTaskClicked(taskDto: TaskDto)

}