package com.example.taskplanner.ui.main

import android.os.Bundle
import android.widget.Toast
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
            if (validFormField() == true){
                viewModel.createUser(editTextIdCreate.text.toString(),editTextNameCreate.text.toString(),editTextPasswordCreate.text.toString(),
                    editTextEmailCreate.text.toString(),editTextProfilePicture.text.toString())
                Toast.makeText(this@CreateAccountActivity,"Congratulations you have created a new account",Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun validFormField():Boolean {

        if (editTextIdCreate.text.isEmpty()){
            editTextIdCreate.error = getString(R.string.field_cannot_be_empty)
            return false
        }
        if (editTextNameCreate.text.isEmpty()){
            editTextNameCreate.error = getString(R.string.field_cannot_be_empty)
            return false
        }
        if (editTextProfilePicture.text.isEmpty()){
            editTextProfilePicture.error = getString(R.string.field_cannot_be_empty)
            return false

        }
        if (editTextEmailCreate.text.isEmpty()){
            editTextEmailCreate.error = getString(R.string.field_cannot_be_empty)
            return false

        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextEmailCreate.text.toString()).matches()){
            editTextEmailCreate.error = getString(R.string.invalid_email_address)
            return false

        }else{
            editTextEmailCreate.error = null
        }

        if (editTextPasswordCreate.text.isEmpty()){
            editTextPasswordCreate.error = getString(R.string.field_cannot_be_empty)
            return false

        }
        return true


    }

}