package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskFragment : Fragment(R.layout.fragment_new_task) {


    val viewModel by viewModels<MainActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonCreateTask = view.findViewById<Button>(R.id.buttonUpdateTask)
        val description = view.findViewById<EditText>(R.id.textViewUpdateDescriptionTask)
        val personResponsable = view.findViewById<EditText>(R.id.textViewUpdatePersonResponsible)
        val dueDate = view.findViewById<EditText>(R.id.textViewUpdateDueDate)
        val status = view.findViewById<EditText>(R.id.textViewUpdateStatus)



        buttonCreateTask.setOnClickListener {

            viewModel.createTask(description.text.toString(),personResponsable.text.toString(),dueDate.text.toString(),status.text.toString())



        }




    }




}