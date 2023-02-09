package com.jle.monkeyfilmapp.login.data

import android.util.Log
import com.jle.monkeyfilmapp.login.data.database.UserPreferencesService
import com.jle.monkeyfilmapp.login.data.database.dao.UserDAO
import com.jle.monkeyfilmapp.login.data.database.dto.toDatabase
import com.jle.monkeyfilmapp.login.data.network.LoginService
import com.jle.monkeyfilmapp.login.data.network.dto.UserDTO
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
    private val userPreferences: UserPreferencesService,
    private val userDAO: UserDAO
) {

    suspend fun doLogin(phone: String, password: String): Boolean {
        val connectionOk: UserDTO? = api.doLogin(phone, password)

        if (connectionOk != null) {
            userPreferences.addToken("token", "asdasdsadasdsadsadas")
            userDAO.insertAll(listOf(connectionOk.toDatabase(userPreferences.getToken("token"))))
            return true
        }
        return false
    }

    //suspend fun getConnectionToken(key: String): Boolean = !userPreferences.getToken(key).isNullOrEmpty()

    suspend fun getConnectionToken(key: String): Boolean {
        return if (!userPreferences.getToken(key).isNullOrEmpty()) {
            Log.i("DAM", "el token es: ${userPreferences.getToken(key)}")
            true
        } else
            false
    }


}