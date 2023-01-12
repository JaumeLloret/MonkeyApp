package es.iesperemaria.monkeyapp.register.data.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
