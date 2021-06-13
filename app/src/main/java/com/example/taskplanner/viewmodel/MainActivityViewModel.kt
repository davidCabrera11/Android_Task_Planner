package com.example.taskplanner.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskplanner.repository.model.dao.TaskDao
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.Task
import com.example.taskplanner.repository.model.entity.User
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.repository.remote.dto.UserDto
import com.example.taskplanner.repository.remote.task.TaskService
import com.example.taskplanner.repository.remote.user.UserService
import com.example.taskplanner.repository.repository.TaskRepository
import com.example.taskplanner.repository.repository.UserRepository
import com.example.taskplanner.storage.Storage
import com.example.taskplanner.ui.adapter.TaskAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val taskRepository: TaskRepository
    ):ViewModel() {

        val successLiveData = MutableLiveData<Boolean>()


    fun syncTaskData(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                taskRepository.syncData()
            }catch (e:Exception){
                Log.e("Developer","Error on syncData",e)

            }
        }


    }



     fun createTask(description:String,personResponsible:String,dueDate:String,status:String) {
         viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.createTask(TaskDto("3123123",description,personResponsible,
                dueDate,status,"123123123"))
            if(response.isSuccessful){
                val task = response.body()!!
                println("Created Task $task")
                taskRepository.taskDao.save(Task(task))
                Log.d("Debug", "Create new task: $task")
            }else{
                response.errorBody()
            }

        }
    }



     fun getTasks() {
         viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.getTasks()
            if(response.isSuccessful){
                val task = response.body()!!
                Log.d("DEBUG", "Get Task: $task")
            }else{
                response.errorBody()
            }

        }
    }


     fun updateTask(id:String,description:String,personResponsible:String,dueDate:String,status:String) {
         viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.updateTask(id,
                TaskDto("3123123",description,personResponsible,
                    dueDate,status,"123123123")
            )
            if(response.isSuccessful){
                val task = response.body()!!
            }else{
                response.errorBody()
            }

        }
    }

    fun deleteTask(id:String){
            viewModelScope.launch(Dispatchers.IO) {
                val response = taskRepository.taskService.deleteTask(id)
                if (response.isSuccessful){
                    val task = response.body()!!
                    Log.d("Deleted","Deleted task $task")
                }else{
                    response.errorBody()
                }
            }
    }

    fun retrieveTaskList(taskAdapter: TaskAdapter){
        viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.getTasks()
            if (response.isSuccessful){
                val task = response.body()!!
                task.forEach{
                    taskRepository.taskDao.save(Task(it))
                }
                viewModelScope.launch(Dispatchers.Main) {
                    taskAdapter.updateTaskList(response.body()!!)
                }

            }



        }



    }













}