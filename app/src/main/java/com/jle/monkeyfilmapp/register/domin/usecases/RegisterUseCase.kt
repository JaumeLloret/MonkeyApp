package com.jle.monkeyfilmapp.register.domin.usecases

import com.jle.monkeyfilmapp.login.domin.entities.UserModel
import com.jle.monkeyfilmapp.register.data.RegisterRepository
import com.jle.monkeyfilmapp.register.data.dto.UserDTO
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository:RegisterRepository){

    suspend operator fun invoke(
        user: UserModel
    ): Boolean {
        return repository.signUp(
            phone = user.phone,
            user = UserDTO(
                name = user.name,
                surname = user.surname,
                birthdate = user.birthdate,
                genre = user.genre,
                email = user.email,
                password = user.password
            )
        )
    }
}