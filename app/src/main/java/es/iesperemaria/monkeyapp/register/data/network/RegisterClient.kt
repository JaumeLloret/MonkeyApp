package es.iesperemaria.monkeyapp.register.data.network

import es.iesperemaria.monkeyapp.register.data.dto.UserDTO
import es.iesperemaria.monkeyapp.register.data.network.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.Path

interface RegisterClient {
    //@Headers("Accept: application/json")
    @PATCH("/user/{phone}.json")
    suspend fun signUp(
        @Path("phone") phone: String,
        @Body user: UserDTO
    ) : Response<RegisterResponse>
}