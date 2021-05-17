package com.example.taskplanner.storage

import android.content.Context
import android.provider.Settings.Global.getString
import com.example.taskplanner.R
import com.example.taskplanner.utils.SHARED_PREFERENCE_FILE_NAME
import dagger.hilt.android.qualifiers.ApplicationContext

class LocalStorage(@ApplicationContext context: Context) : Storage {

    val sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)

    override fun saveToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun getToken(): String {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}