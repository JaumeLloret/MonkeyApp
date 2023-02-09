package com.jle.monkeyfilmapp.register.data.network

import com.jle.monkeyfilmapp.register.data.network.response.RegisterResponse
import com.jle.monkeyfilmapp.register.data.dto.UserDTO
import com.jle.monkeyfilmapp.register.data.network.response.UploadImageResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RegisterClient {
    //@Headers("Accept: application/json")
    @PATCH("/user/{phone}.json")
    suspend fun signUp(
        @Path("phone") phone: String,
        @Body user: UserDTO
    ):Response<RegisterResponse>

    @Multipart
    @POST
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("name") name: String,
        @Part("type") type: String
    ): Call<UploadImageResponse>


}