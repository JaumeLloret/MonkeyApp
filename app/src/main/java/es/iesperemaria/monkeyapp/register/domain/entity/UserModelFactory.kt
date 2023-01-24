package es.iesperemaria.monkeyapp.register.domain.entity

import javax.inject.Inject

class UserModelFactory @Inject constructor(){
    operator fun invoke(
        name: String,
        surname: String,
        phone: String,
        genre: String,
        email: String,
        birthdate: String,
        password: String,
    ): UserModel {
        return UserModel(
            phone = phone,
            name = name,
            surname = surname,
            birthdate = birthdate,
            genre = genre,
            email = email,
            password = password,
            preferences = listOf()
        )
    }
}