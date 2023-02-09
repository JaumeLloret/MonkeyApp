package com.jle.monkeyfilmapp.login.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jle.monkeyfilmapp.login.data.database.dto.UserDTO

interface UserDAO {
    @Query("SELECT * FROM user_table ORDER BY name DESC")
    suspend fun getAllUsers():List<UserDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users:List<UserDTO>)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}