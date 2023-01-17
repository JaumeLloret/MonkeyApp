package com.jle.monkeyfilmapp.register.data.network

import com.jle.monkeyfilmapp.register.data.network.response.RegisterResponse
import com.jle.monkeyfilmapp.register.data.dto.UserDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface RegisterClient {
    //@Headers("Accept: application/json")
    @PATCH("/user/{phone}.json")
    suspend fun signUp(
        @Path("phone") phone: String,
        @Body user: UserDTO
    ):Response<RegisterResponse>
}