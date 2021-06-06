package com.example.taskplanner.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.taskplanner.R
import com.example.taskplanner.databinding.ActivityMainBinding
import com.example.taskplanner.repository.model.dao.TaskDao
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.Task
import com.example.taskplanner.repository.model.entity.User
import com.example.taskplanner.repository.remote.task.TaskService
import com.example.taskplanner.repository.remote.user.UserService
import com.example.taskplanner.storage.Storage
import com.example.taskplanner.ui.fragments.NewTaskFragment
import com.example.taskplanner.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)










    }


}