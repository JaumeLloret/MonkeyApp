package es.iesperemaria.monkeyapp.register.data

import es.iesperemaria.monkeyapp.register.data.dto.UserDTO
import es.iesperemaria.monkeyapp.register.data.network.RegisterService
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val api: RegisterService) {
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