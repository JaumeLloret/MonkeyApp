package com.jle.monkeyfilmapp.login.data.database

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.jle.monkeyfilmapp.login.data.datastorage.IUserPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject


class UserPreferencesService @Inject constructor(private val dataStore: DataStore<Preferences>) :
    IUserPreferences {
    override suspend fun addToken(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[preferenceKey] = value
        }
    }

    override suspend fun getToken(key: String): String {
        return try {
            val preferenceKey = stringPreferencesKey(key)
            val preferences = dataStore.data.first()
            preferences[preferenceKey] ?: ""
        } catch (e: Exception) {
            Log.e("DAM", "error: ${e.message}")
            ""
        }
    }
}