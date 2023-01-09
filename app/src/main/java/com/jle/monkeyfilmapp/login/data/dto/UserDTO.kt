package com.jle.monkeyfilmapp.login.data.dto

data class UserDTO(
    val name: String,
    val surname: String,
    val birthdate: String,
    val genre: String,
    val preferences: List<String>,
    val email: String,
    val password: String)