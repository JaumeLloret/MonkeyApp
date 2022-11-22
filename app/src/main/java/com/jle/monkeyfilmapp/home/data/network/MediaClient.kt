package com.jle.monkeyfilmapp.home.data.network

import com.jle.monkeyfilmapp.home.data.network.response.MediaResponse
import retrofit2.Response
import retrofit2.http.GET

interface MediaClient {

    //https://run.mocky.io/v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9
    @GET("v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    suspend fun getMedia(filter: String):Response<MediaResponse>
}