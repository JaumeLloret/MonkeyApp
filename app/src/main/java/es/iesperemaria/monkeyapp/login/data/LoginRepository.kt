package es.iesperemaria.monkeyapp.login.data

import android.util.Log
import es.iesperemaria.monkeyapp.login.data.db.UserPreferenceService
import es.iesperemaria.monkeyapp.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
    private val db: UserPreferenceService
){
    suspend fun doLogin(user: String, password: String) : Boolean {
        val connectionOK = api.doLogin(user, password)
        if (connectionOK) {
            db.addToken("user", "Miriam")
            db.addToken("peso", "10gr")
            db.addToken("token", "asdsadasdasdasdasdasf")
        }
        return connectionOK
    }

    suspend fun getConnectionToken(): Boolean {
        return if(!db.getToken("token").isNullOrEmpty()) {
            Log.i("DAM", "El token es: ${db.getToken("token")}")
            true
        }
        else
            false
    }
}