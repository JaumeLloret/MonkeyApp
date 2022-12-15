package com.jle.monkeyfilmapp.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("name") val name: String,
                         @SerializedName("surname") val surname: String,
                         @SerializedName("birthdate") val birthdate: String,
                         @SerializedName("genre") val genre: String,
                         @SerializedName("preferences") val preferences: List<String>,
                         @SerializedName("email") val email: String,
                         @SerializedName("password") val password: String)


