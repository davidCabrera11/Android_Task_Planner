package com.example.taskplanner.ui.main

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.taskplanner.R
import com.example.taskplanner.ui.fragments.NewTaskFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.newTaskFragment, NewTaskFragment())
            commit()
        }



    }


}