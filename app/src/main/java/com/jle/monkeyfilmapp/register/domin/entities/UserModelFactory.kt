package com.jle.monkeyfilmapp.register.domin.entities

import com.jle.monkeyfilmapp.login.domin.entities.UserModel
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