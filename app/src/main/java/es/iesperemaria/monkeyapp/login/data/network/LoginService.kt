package es.iesperemaria.monkeyapp.login.data.network

import android.util.Log
import es.iesperemaria.monkeyapp.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(user: String, password: String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin(user)
            Log.i("DAM", "data: ${response.body()}")
            response.body()?.password!!.compareTo(password) == 0
        }
    }
}