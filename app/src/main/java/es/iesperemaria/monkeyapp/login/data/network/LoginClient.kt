package es.iesperemaria.monkeyapp.login.data.network

import es.iesperemaria.monkeyapp.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginClient {
    @GET("/user/{phone}.json")
    suspend fun doLogin(@Path("phone") phone:String):Response<LoginResponse>
}