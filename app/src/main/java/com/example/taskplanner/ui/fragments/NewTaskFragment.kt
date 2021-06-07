package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.repository.remote.task.TaskService
import com.example.taskplanner.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewTaskFragment : Fragment(R.layout.fragment_new_task) {


    val viewModel by viewModels<MainActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonCreateTask = view.findViewById<Button>(R.id.buttonCreateTask)
        val description = view.findViewById<EditText>(R.id.editTextDescriptionTask)
        val personResponsable = view.findViewById<EditText>(R.id.editTextPersonResponsible)
        val dueDate = view.findViewById<EditText>(R.id.editTextDueDate)
        val status = view.findViewById<EditText>(R.id.editTextStatus)



        buttonCreateTask.setOnClickListener {

            viewModel.createTask(description.text.toString(),personResponsable.text.toString(),dueDate.text.toString(),status.text.toString())



        }




    }




}