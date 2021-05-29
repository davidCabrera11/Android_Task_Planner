package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.CreateAccountViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnCreateAccount

@AndroidEntryPoint
class CreateAccountActivity:AppCompatActivity() {

    val viewModel by viewModels<CreateAccountViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        btnCreateAccount.setOnClickListener {
            viewModel.createUser(editTextIdCreate.text.toString(),editTextNameCreate.text.toString(),editTextPasswordCreate.text.toString(),
                editTextEmailCreate.text.toString(),imageViewProfilePicture.toString())



        }




    }

}