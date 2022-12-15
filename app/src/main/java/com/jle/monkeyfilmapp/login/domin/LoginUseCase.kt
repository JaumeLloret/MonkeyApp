package com.jle.monkeyfilmapp.login.domin

import com.jle.monkeyfilmapp.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository:LoginRepository){

    suspend operator fun invoke(phone: String, password: String): Boolean {
        return repository.doLogin(phone, password)
    }
}