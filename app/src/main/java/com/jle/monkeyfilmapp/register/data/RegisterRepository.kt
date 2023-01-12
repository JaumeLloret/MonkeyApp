package com.jle.monkeyfilmapp.register.data

import com.jle.monkeyfilmapp.register.data.dto.UserDTO
import com.jle.monkeyfilmapp.register.data.network.RegisterService
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val api:RegisterService) {

    suspend fun signUp(
        phone: String,
        user: UserDTO
    ) : Boolean {
        return api.signUp(
            phone = phone,
            user = user
        )
    }
}