package es.iesperemaria.monkeyapp.register.domain.usecase

import es.iesperemaria.monkeyapp.register.data.RegisterRepository
import es.iesperemaria.monkeyapp.register.data.dto.UserDTO
import es.iesperemaria.monkeyapp.register.domain.entity.UserModel
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: RegisterRepository) {

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