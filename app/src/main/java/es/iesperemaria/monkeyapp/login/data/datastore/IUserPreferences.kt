package es.iesperemaria.monkeyapp.login.data.datastore

interface IUserPreferences {
 suspend fun addToken(key: String, value: String)
 suspend fun getToken(key: String): String
}