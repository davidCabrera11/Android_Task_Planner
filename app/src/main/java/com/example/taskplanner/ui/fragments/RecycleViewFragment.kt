package com.example.taskplanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RecycleViewFragment : Fragment(R.layout.fragment_recycle_view) {


    val viewModel by viewModels<MainActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fabButton = view.findViewById<FloatingActionButton>(R.id.fabCreateTask)


        fabButton.setOnClickListener {
            findNavController().navigate(R.id.action_recycleViewFragment_to_newTaskFragment)

        }


    }





}