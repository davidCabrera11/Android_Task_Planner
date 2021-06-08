package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.viewmodel.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskDetailFragment : Fragment(R.layout.fragment_task_detail,) {

    val viewModel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val description = view.findViewById<EditText>(R.id.textViewUpdateDescriptionTask)
        val personResponsible = view.findViewById<EditText>(R.id.textViewUpdatePersonResponsible)
        val dueDate = view.findViewById<EditText>(R.id.textViewUpdateDueDate)
        val status = view.findViewById<EditText>(R.id.textViewUpdateStatus)

        val updateButton = view.findViewById<Button>(R.id.buttonUpdateTask)

        updateButton.setOnClickListener {
            viewModel.updateTask(description.text.toString(),personResponsible.text.toString(),
                dueDate.text.toString(),status.text.toString())

        }



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