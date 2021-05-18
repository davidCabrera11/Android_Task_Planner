package com.example.taskplanner.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taskplanner.R
import com.example.taskplanner.repository.auth.AuthService
import com.example.taskplanner.repository.dto.LoginDto
import com.example.taskplanner.repository.dto.UserDto
import com.example.taskplanner.repository.task.TaskService
import com.example.taskplanner.repository.user.UserService
import com.example.taskplanner.storage.LocalStorage
import com.example.taskplanner.storage.Storage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Developer","token ${storage.getToken()}")

        createUser()
        findUserById()
        getUsers()
       /* updateUser()
        deleteUser()*/


        findTaskById()


    }



    private fun createUser() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = userService.createUser(UserDto("1002031231","David Cabrera","password1","dcab3123@gmail.com","https://imgur.com/t/kotlin/QPd2a"))
            if(response.isSuccessful){
                val user = response.body()!!
                Log.d("DEBUG", "Create new user: $user")
            }else{
                response.errorBody()
            }

        }    }


    private fun findUserById(){
            GlobalScope.launch(Dispatchers.IO) {
                val response = userService.findUserById("60986fda6619f922895259c8")
                if(response.isSuccessful){
                    val user = response.body()!!
                    Log.d("DEBUG", "UserId: $user")
                }else{
                    response.errorBody()
                }

            }
    }

    private fun getUsers() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = userService.getUsers()
            if(response.isSuccessful){
                val user = response.body()!!
                Log.d("DEBUG", "Get UserId's : $user")
            }else{
                response.errorBody()
            }

        }
    }

  /*  private fun updateUser() {
        TODO("Not yet implemented")
    }

    private fun deleteUser() {
        TODO("Not yet implemented")
    }
*/





    private fun findTaskById() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = taskService.findTaskById("609b11f76bb84e5de36c05c7")
            if(response.isSuccessful){
                val task = response.body()!!
                Log.d("DEBUG", "TaskId: $task")
            }else{
                response.errorBody()
            }

        }
    }






}