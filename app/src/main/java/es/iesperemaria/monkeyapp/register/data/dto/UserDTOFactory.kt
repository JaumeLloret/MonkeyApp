package es.iesperemaria.monkeyapp.register.data.dto

import javax.inject.Inject

class UserDTOFactory @Inject constructor() {
    operator fun invoke (
        name: String,
        surname: String,
        genre: String,
        email: String,
        birthdate: String,
        password: String,
    ) : UserDTO {
        return UserDTO(
            name = name,
            surname = surname,
            birthdate = birthdate,
            genre = genre,
            email = email,
            password = password,
        )
    }
}