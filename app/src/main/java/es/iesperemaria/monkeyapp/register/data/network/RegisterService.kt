package es.iesperemaria.monkeyapp.register.data.network

import android.util.Log
import es.iesperemaria.monkeyapp.register.data.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterService @Inject constructor(private val registerClient: RegisterClient) {
    suspend fun signUp(
        phone: String,
        user: UserDTO
    ): Boolean {
        return withContext(Dispatchers.IO) {
            val response = registerClient.signUp(
                phone = phone,
                user = user
            )
            Log.i("DAM", "data: ${response.body()}")
            response.body()?.password!!.compareTo(user.password) == 0
        }
    }
}