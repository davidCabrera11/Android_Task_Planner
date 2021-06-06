package com.example.taskplanner.ui.main

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.databinding.ActivityMainBinding
import com.example.taskplanner.databinding.ActivityTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskBinding

/*
    val viewModel by viewModels<MainActivityViewModel>()
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


}