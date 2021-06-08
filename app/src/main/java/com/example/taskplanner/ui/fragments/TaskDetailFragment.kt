package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto


class TaskDetailFragment : Fragment(R.layout.fragment_task_detail,) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val description = view?.findViewById<EditText>(R.id.textViewUpdateDescriptionTask)
        val personResponsible = view?.findViewById<EditText>(R.id.textViewUpdatePersonResponsible)
        val dueDate = view?.findViewById<EditText>(R.id.textViewUpdateDueDate)
        val status = view?.findViewById<EditText>(R.id.textViewUpdateStatus)

        val taskDto:TaskDto = arguments?.getSerializable("task") as TaskDto
        updateSelectedTaskInfo(taskDto, description, personResponsible, dueDate, status)

    }

    private fun updateSelectedTaskInfo(taskDto: TaskDto, description: EditText,
                                       personResponsible:EditText,dueDate:EditText,status:EditText) {

        description.setText(taskDto.description)
        personResponsible.setText(taskDto.personResponsible)
        dueDate.setText(taskDto.dueDate)
        status.setText(taskDto.status)

    }


}