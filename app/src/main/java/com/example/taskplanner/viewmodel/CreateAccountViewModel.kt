package com.example.taskplanner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskplanner.repository.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {

    val successLiveData = MutableLiveData<Boolean>()

    fun createUser(){



    }




}