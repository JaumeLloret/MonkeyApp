package com.jle.monkeyfilmapp.register.data.dto

data class UserDTO(
    val name: String,
    val surname: String,
    val birthdate: String,
    val genre: String,
    val preferences: List<String>,
    val email: String,
    val password: String)