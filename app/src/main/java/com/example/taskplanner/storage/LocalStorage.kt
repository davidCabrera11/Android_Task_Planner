package com.example.taskplanner.storage

import android.content.Context
import android.provider.Settings.Global.getString
import com.example.taskplanner.R
import com.example.taskplanner.utils.SHARED_PREFERENCE_FILE_NAME
import com.example.taskplanner.utils.TOKEN_KEY
import dagger.hilt.android.qualifiers.ApplicationContext

class LocalStorage(context: Context) : Storage {

    val sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)

    override fun saveToken(token: String) {
        sharedPref.edit().putString(TOKEN_KEY,token).apply()

     }

    override fun getToken(): String {
        return sharedPref.getString(TOKEN_KEY,"")!!
     }

    override fun clear() {
        return sharedPref.edit()
            .remove(TOKEN_KEY)
            .apply()

     }
}