package com.jle.monkeyfilmapp.login.data.network

import com.jle.monkeyfilmapp.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginClient {
    @GET("/user/{phone}.json")
    suspend fun doLogin(@Path("phone") phone: String):Response<LoginResponse>
}