package es.iesperemaria.monkeyapp.login.data.network

import android.util.Log
import es.iesperemaria.monkeyapp.core.network.RetrofitHelper
import es.iesperemaria.monkeyapp.login.data.network.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(user: String, password: String) : UserDTO? {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin(user)
            Log.i("DAM", "data: ${response.body()}")
            if(response.body()?.password!!.compareTo(password) == 0)
                UserDTO(
                    name = response.body()?.name!!,
                    surname = response.body()?.surname!!,
                    birthdate = response.body()?.birthdate!!,
                    genre = response.body()?.genre!!,
                    email = response.body()?.email!!,
                )
            else
                null
        }
    }
}