package com.jle.monkeyfilmapp.register.data

import com.jle.monkeyfilmapp.login.data.network.RegisterService
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val api:RegisterService) {

    suspend fun doLogin(phone: String, password: String) : Boolean {
        return api.doLogin(phone, password)
    }
}