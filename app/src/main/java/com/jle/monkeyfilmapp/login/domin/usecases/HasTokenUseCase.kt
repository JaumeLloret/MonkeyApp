package com.jle.monkeyfilmapp.login.domin.usecases

import com.jle.monkeyfilmapp.login.data.LoginRepository
import javax.inject.Inject

class HasTokenUseCase @Inject constructor(private val repository: LoginRepository){
    suspend operator fun invoke(): Boolean = repository.getConnectionToken("token")
}