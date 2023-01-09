package com.jle.monkeyfilmapp.register.domin.usecases

import com.jle.monkeyfilmapp.register.data.RegisterRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository:RegisterRepository){

    suspend operator fun invoke(phone: String, password: String): Boolean {
        return repository.doLogin(phone, password)
    }
}