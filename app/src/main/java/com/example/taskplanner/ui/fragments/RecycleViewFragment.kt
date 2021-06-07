package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.ui.adapter.TaskAdapter
import com.example.taskplanner.ui.adapter.TaskAdapterListener
import com.example.taskplanner.viewmodel.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recycle_view.*

@AndroidEntryPoint
class RecycleViewFragment : Fragment(R.layout.fragment_recycle_view), TaskAdapterListener {


    val viewModel by viewModels<MainActivityViewModel>()

    val taskAdapter = TaskAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.runOnUiThread {
            viewModel.getTasks()
            viewModel.retrieveTaskList(taskAdapter)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fabButton = view.findViewById<FloatingActionButton>(R.id.fabCreateTask)


        fabButton.setOnClickListener {
            findNavController().navigate(R.id.action_recycleViewFragment_to_newTaskFragment)

        }

        configureRecyclerView()

    }

    private fun configureRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerViewTasks.layoutManager = linearLayoutManager
        recyclerViewTasks.adapter = taskAdapter

     }

    override fun onTaskClicked(taskDto: TaskDto) {
        findNavController().navigate(R.id.action_recycleViewFragment_to_taskDetailFragment)

    }


}