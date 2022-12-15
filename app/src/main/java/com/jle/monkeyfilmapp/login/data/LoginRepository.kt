package com.jle.monkeyfilmapp.login.data

import com.jle.monkeyfilmapp.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api:LoginService) {

    suspend fun doLogin(phone: String, password: String) : Boolean {
        return api.doLogin(phone, password)
    }
}