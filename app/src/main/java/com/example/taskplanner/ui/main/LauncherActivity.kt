package com.example.taskplanner.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskplanner.storage.Storage
import javax.inject.Inject

class LauncherActivity :AppCompatActivity(){

    @Inject
    lateinit var storage: Storage

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        if(storage.getToken().isNotEmpty()){
            startMainActivity()
        }else{
            startLoginActivity()
        }
        finish()

    }

    private fun startLoginActivity() {
        val intent = Intent(this,LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}