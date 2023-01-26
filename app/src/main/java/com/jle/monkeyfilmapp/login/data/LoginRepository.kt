package com.jle.monkeyfilmapp.login.data

import android.util.Log
import com.jle.monkeyfilmapp.login.data.db.UserPreferencesService
import com.jle.monkeyfilmapp.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api:LoginService, private val userPreferences:UserPreferencesService) {

    suspend fun doLogin(phone: String, password: String) : Boolean {
        val connectionOk = api.doLogin(phone, password)
        if (connectionOk) {
            userPreferences.addToken("token", "asdasdsadasdsadsadas")
        }
        return connectionOk
    }

    //suspend fun getConnectionToken(key: String): Boolean = !userPreferences.getToken(key).isNullOrEmpty()

    suspend fun getConnectionToken(key: String): Boolean {
        return if(!userPreferences.getToken(key).isNullOrEmpty()) {
            Log.i("DAM", "el token es: ${userPreferences.getToken(key)}")
            true
        }
        else
            false
    }
}