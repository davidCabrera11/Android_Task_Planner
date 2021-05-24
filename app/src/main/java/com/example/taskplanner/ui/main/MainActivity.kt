package com.example.taskplanner.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taskplanner.R
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.User
import com.example.taskplanner.repository.remote.task.TaskService
import com.example.taskplanner.repository.remote.user.UserService
import com.example.taskplanner.storage.Storage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var storage: Storage

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var taskService: TaskService

    @Inject
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Developer","token ${storage.getToken()}")

        //User Service CRUD
        findUserById()

        //TaskService CRUD
        findTaskById()

    }

    private fun findUserById(){
            GlobalScope.launch(Dispatchers.IO) {
                val response = userService.findUserById("6099af1ab755fe29152c9272")
                if(response.isSuccessful){
                    val user = response.body()!!
                    Log.d("DEBUG", "UserId: $user")
                    userDao.save(User(user))
                }else{
                    response.errorBody()
                }

            }
    }


    private fun findTaskById() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = taskService.findTaskById("60a3326448abc1562e500144")
            if(response.isSuccessful){
                val task = response.body()!!
                Log.d("DEBUG", "Find task by id: $task")
            }else{
                response.errorBody()
            }

        }
    }


}