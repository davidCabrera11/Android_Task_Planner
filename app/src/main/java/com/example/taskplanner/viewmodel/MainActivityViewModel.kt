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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val storage: Storage,
    private val userRepository: UserRepository,
    private val taskRepository: TaskRepository
    ):ViewModel() {

        val successLiveData = MutableLiveData<Boolean>()

    fun findUserById(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = userRepository.userService.findUserById("6099af1ab755fe29152c9272")
            if(response.isSuccessful){
                val user = response.body()!!
                Log.d("DEBUG", "UserId: $user")
                successLiveData.postValue(true)
                userRepository.userDao.save(User(user))

            }else{
                response.errorBody()
                successLiveData.postValue(false)

            }

        }

    }

    fun updateUser() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = userRepository.userService.updateUser("6099af1ab755fe29152c9272",
                UserDto("","Itachi","securePassword123","jorge123@gmail.com","imgur.com"))
            if(response.isSuccessful){
                val user = response.body()!!
                Log.d("DEBUG", "Updated UserId's : $user")
                successLiveData.postValue(true)
                userRepository.userDao.save(User(user))

            }else{
                response.errorBody()
                successLiveData.postValue(false)

            }

        }
    }

    fun findTaskById(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.findTaskById("60a3326448abc1562e500144")
            if(response.isSuccessful){
                val task = response.body()!!
                Log.d("DEBUG", "Find task by id: $task")
                successLiveData.postValue(true)
                taskRepository.taskDao.save(Task(task))
            }else{
                response.errorBody()
                successLiveData.postValue(false)
            }
        }
    }

    fun updateTask() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = taskRepository.taskService.updateTask("60a3326448abc1562e500144",
                TaskDto("3123123","Complete house chores","Test",
                    "2021-05-19T03:18:42.507+00:00","To-do","123123123")
            )
            if(response.isSuccessful){
                val task = response.body()!!
                Log.d("DEBUG", "Updated task: $task")
                successLiveData.postValue(true)
                taskRepository.taskDao.save(Task(task))

            }else{
                response.errorBody()
                successLiveData.postValue(false)

            }

        }
    }




}