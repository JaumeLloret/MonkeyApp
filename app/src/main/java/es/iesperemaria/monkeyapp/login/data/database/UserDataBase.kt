package es.iesperemaria.monkeyapp.login.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import es.iesperemaria.monkeyapp.login.data.database.dao.UserDAO
import es.iesperemaria.monkeyapp.login.data.database.dto.UserDTO

@Database(entities = [UserDTO::class], version = 1)
abstract class UserDataBase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
}