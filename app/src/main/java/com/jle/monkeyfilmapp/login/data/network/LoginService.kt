package com.jle.monkeyfilmapp.login.data.network

import com.jle.monkeyfilmapp.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    /*suspend fun doLogin(user: String, password:String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.logInOk ?: false
        }
    }*/

    suspend fun doLogin(user: String, password:String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.logInOk ?: false
        }
    }
}