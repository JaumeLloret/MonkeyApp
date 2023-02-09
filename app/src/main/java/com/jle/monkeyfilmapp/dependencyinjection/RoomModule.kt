package com.jle.monkeyfilmapp.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.jle.monkeyfilmapp.login.data.database.dao.UserDAO
import com.jle.monkeyfilmapp.login.data.datastorage.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val MONKEY_FILM_DATABASE_NAME = "quote_database"

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UserDataBase::class.java, MONKEY_FILM_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: UserDataBase) : UserDAO = db.getUserDAO()
}