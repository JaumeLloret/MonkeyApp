package com.jle.monkeyfilmapp.login.data.network

import com.jle.monkeyfilmapp.login.data.network.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RegisterClient {
    //@Headers("Accept: application/json")
    @GET("/user/{phone}.json")
    suspend fun doLogin(@Path("phone") phone: String):Response<RegisterResponse>
}