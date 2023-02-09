package es.iesperemaria.monkeyapp.login.data.network.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    val name: String,
    val surname: String,
    val birthdate: String,
    val genre: String,
    val email: String
)
