package com.jle.monkeyfilmapp.login.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(phone: String, password:String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin(phone)
            Log.i("DAM", "data: ${response.body()}")
            response.body()?.password!!.compareTo(password) == 0
        }
    }
}