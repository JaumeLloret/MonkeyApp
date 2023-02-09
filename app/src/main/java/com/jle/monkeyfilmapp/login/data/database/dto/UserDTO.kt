package com.jle.monkeyfilmapp.login.data.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDTO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String,
    @ColumnInfo(name = "birthdate") val birthdate: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "preferences") val preferences: List<String>,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "token") val token: String
)

fun com.jle.monkeyfilmapp.login.data.network.dto.UserDTO.toDatabase(token: String) =
    UserDTO(
        name = name,
        surname = surname,
        birthdate = birthdate,
        genre = genre,
        preferences = preferences,
        email= email,
        token = token
    )