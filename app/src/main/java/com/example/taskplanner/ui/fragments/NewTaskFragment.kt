package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
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
        val statusSpinner = view.findViewById<Spinner>(R.id.spinnerCreateStatus)


        statusSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }


        buttonCreateTask.setOnClickListener {
            viewModel.createTask(description.text.toString(),personResponsable.text.toString(),
                dueDate.text.toString(),statusSpinner.selectedItem.toString())
            Toast.makeText(context,"New task created", Toast.LENGTH_SHORT).show()
        }

    }


}