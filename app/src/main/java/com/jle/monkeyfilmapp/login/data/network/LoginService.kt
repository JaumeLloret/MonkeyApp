package com.jle.monkeyfilmapp.login.data.network

import android.util.Log
import com.jle.monkeyfilmapp.login.data.network.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(phone: String, password:String) : UserDTO? {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin(phone)
            Log.i("DAM", "data: ${response.body()}")
            if(response.body()?.password!!.compareTo(password) == 0)
                UserDTO(
                    name = response.body()?.name!!,
                    surname = response.body()?.surname!!,
                    birthdate = response.body()?.birthdate!!,
                    genre = response.body()?.genre!!,
                    email = response.body()?.email!!,
                    preferences =  response.body()?.preferences!!
                )
            else
                null
        }
    }
}