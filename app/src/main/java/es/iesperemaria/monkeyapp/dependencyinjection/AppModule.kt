package es.iesperemaria.monkeyapp.dependencyinjection

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.iesperemaria.monkeyapp.login.data.database.UserDataBase
import es.iesperemaria.monkeyapp.login.data.database.dao.UserDAO
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences"
private const val MONKEY_APP_DATABASE_NAME = "monkeyDB"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES)

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContex(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideDataStore(context: Context): DataStore<Preferences> = context.dataStore

    @Provides
    @Singleton
    fun provideRoom(context: Context) =
        Room.databaseBuilder(context, UserDataBase::class.java, MONKEY_APP_DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideUserDAO(db: UserDataBase) : UserDAO = db.getUserDAO()
}