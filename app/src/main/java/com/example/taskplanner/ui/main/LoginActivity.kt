package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.LoginActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {


    val viewModel by viewModels<LoginActivityViewModel>()

    val button = findViewById<Button>(R.id.btnLogin)

    val emailEditText = findViewById<EditText>(R.id.editTextEmail)

    val passwordEditText = findViewById<EditText>(R.id.editTextPassword)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        button.setOnClickListener {
            if (validFormField()){

            }

        }

        viewModel.successLiveData.observe(this, {success ->
            if (success){
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        })
        //viewModel.auth()
    }

    private fun validFormField(): Boolean {

        if (emailEditText.text.isEmpty()){
            emailEditText.error = getString(R.string.field_cannot_be_empty)
            return false
        }else if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.text).matches()){
            emailEditText.error = getString(R.string.invalid_email_address)
            return false
        }else{
            emailEditText.error = null
        }

        if (passwordEditText.text.isEmpty()){
            passwordEditText.error = getString(R.string.field_cannot_be_empty)
            return false
        }


        return true


    }


}