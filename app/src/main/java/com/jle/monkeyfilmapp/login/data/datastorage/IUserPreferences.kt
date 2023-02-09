package com.jle.monkeyfilmapp.login.data.datastorage

interface IUserPreferences {
    suspend fun addToken(key: String, value: String)

    suspend fun getToken(key: String): String
}