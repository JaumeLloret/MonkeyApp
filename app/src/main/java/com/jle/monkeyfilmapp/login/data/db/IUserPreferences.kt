package com.jle.monkeyfilmapp.login.data.db

interface IUserPreferences {
    suspend fun addToken(key: String, value: String)

    suspend fun getToken(key: String): String
}