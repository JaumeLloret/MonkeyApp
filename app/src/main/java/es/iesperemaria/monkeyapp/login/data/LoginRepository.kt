package es.iesperemaria.monkeyapp.login.data

import android.util.Log
import es.iesperemaria.monkeyapp.login.data.database.dao.UserDAO
import es.iesperemaria.monkeyapp.login.data.database.dto.toDataBase
import es.iesperemaria.monkeyapp.login.data.datastore.UserPreferenceService
import es.iesperemaria.monkeyapp.login.data.network.LoginService
import es.iesperemaria.monkeyapp.login.data.network.dto.UserDTO
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
    private val userPreference: UserPreferenceService,
    private val userDAO: UserDAO
) {
    suspend fun doLogin(user: String, password: String): Boolean {
        val user: UserDTO? = api.doLogin(user, password)
        if (user != null) {
            userPreference.addToken("token", "asdsadasdasdasdasdasf")
            userDAO.insertAll(
                listOf(user.toDataBase(userPreference.getToken("token")))
            )
            return true
        }
        return false
    }

    suspend fun getConnectionToken(): Boolean {
        return if (!userPreference.getToken("token").isNullOrEmpty()) {
            Log.i("DAM", "El token es: ${userPreference.getToken("token")}")
            true
        } else
            false
    }

    suspend fun isUserConnected(): Boolean = userDAO.getAllUsers().count() > 1
}