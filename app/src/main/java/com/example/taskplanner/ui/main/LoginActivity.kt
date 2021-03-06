package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.R
import com.example.taskplanner.viewmodel.LoginActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class   LoginActivity: AppCompatActivity() {


    val viewModel by viewModels<LoginActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if (validFormField() == true){
                viewModel.auth(editTextEmail.text.toString(),editTextPassword.text.toString())
            }else{
                Toast.makeText(this,"Email or Password format incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        btnCreateAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity,CreateAccountActivity::class.java))
        }

        viewModel.successLiveData.observe(this, {success ->
            if (success){
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        })
    }

    private fun validFormField(): Boolean {

        if (editTextEmail.text.isEmpty()){
            editTextEmail.error = getString(R.string.field_cannot_be_empty)
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextEmail.text.toString()).matches()){
            Log.d("Developer: ",editTextEmail.text.toString())
            editTextEmail.error = getString(R.string.invalid_email_address)
            return false
        }else{
            editTextEmail.error = null
        }

        if (editTextPassword.text.isEmpty()){
            editTextPassword.error = getString(R.string.field_cannot_be_empty)
            return false
        }


        return true


    }


}