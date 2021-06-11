package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.fragment.app.viewModels
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
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

        val updateButton = view.findViewById<Button>(R.id.buttonUpdateTask)
        val deleteButton = view.findViewById<Button>(R.id.buttonDeleteTask)

        val statusSpinner = view.findViewById<Spinner>(R.id.spinnerCreateStatus)

        val taskDto:TaskDto = arguments?.getSerializable("task") as TaskDto


        statusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long){

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        showSelectedTaskDetails(taskDto, description, personResponsible, dueDate, statusSpinner, statusSpinner.selectedItemPosition)


        updateButton.setOnClickListener {
            viewModel.updateTask(taskDto.id,description.text.toString(),personResponsible.text.toString(),
                dueDate.text.toString(),statusSpinner.selectedItem.toString())
            Toast.makeText(context,"Task Updated", Toast.LENGTH_SHORT).show()



        }

        deleteButton.setOnClickListener {

            Toast.makeText(context,"Task Deleted", Toast.LENGTH_SHORT).show()



        }

    }

    private fun showSelectedTaskDetails(taskDto: TaskDto, description: EditText,
                                       personResponsible:EditText,dueDate:EditText,status: Spinner,selectedItem:Int) {

        description.setText(taskDto.description)
        personResponsible.setText(taskDto.personResponsible)
        dueDate.setText(taskDto.dueDate)
        status.setSelection(selectedItem)

    }


}