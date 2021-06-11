package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.viewModels
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

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
        val status = view.findViewById<Spinner>(R.id.spinnerUpdateStatus)

        val updateButton = view.findViewById<Button>(R.id.buttonUpdateTask)


        val taskDto:TaskDto = arguments?.getSerializable("task") as TaskDto
/*
        updateSelectedTaskInfo(taskDto, description, personResponsible, dueDate, status)
*/


        updateButton.setOnClickListener {
       /*     viewModel.updateTask(taskDto.id,description.text.toString(),personResponsible.text.toString(),
                dueDate.text.toString(),status.text.toString())*/

        }

    }

    private fun updateSelectedTaskInfo(taskDto: TaskDto, description: EditText,
                                       personResponsible:EditText,dueDate:EditText,status:EditText) {

        var newDate:String =  taskDto.dueDate

        newDate = SimpleDateFormat("dd-MM-yyyy", Locale.US).toString()


        description.setText(taskDto.description)
        personResponsible.setText(taskDto.personResponsible)
        dueDate.setText(newDate)
        status.setText(taskDto.status)

    }


}