package com.jle.monkeyfilmapp.login.domin.entities

data class UserModel(
    val name: String,
    val surname: String,
    val birthdate: String,
    val genre: String,
    val preferences: List<String>,
    val email: String,
    val phone: String,
    val password: String)
