package com.jle.monkeyfilmapp.login.data.datastorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jle.monkeyfilmapp.login.data.database.dao.UserDAO
import com.jle.monkeyfilmapp.login.data.database.dto.UserDTO

@Database(entities = [UserDTO::class], version = 1)
abstract class UserDataBase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
}