package es.iesperemaria.monkeyapp.login.data.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserDTO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("surname") val surname: String,
    @ColumnInfo("birthdate") val birthdate: String,
    @ColumnInfo("genre") val genre: String,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("token") val token: String
)

fun es.iesperemaria.monkeyapp.login.data.network.dto.UserDTO.toDataBase(token: String) =
    UserDTO(
        name = name,
        surname = surname,
        birthdate = birthdate,
        genre = genre,
        email = email,
        token = token
    )