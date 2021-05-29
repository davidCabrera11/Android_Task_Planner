package com.example.taskplanner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.User
import com.example.taskplanner.repository.remote.dto.UserDto
import com.example.taskplanner.repository.repository.UserRepository
import com.example.taskplanner.storage.Storage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {


    fun createUser(id:String, name:String, password:String, email:String, profilePicture:String){

        viewModelScope.launch(Dispatchers.IO){
            val response = userRepository.userService.createUser(UserDto(id,name,password,email,profilePicture))
            if(response.isSuccessful){
                val user = response.body()!!
                userRepository.userDao.save(User(user))

            }else{
                response.errorBody()
            }

        }



    }




}