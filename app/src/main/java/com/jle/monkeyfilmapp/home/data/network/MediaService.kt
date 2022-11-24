package com.jle.monkeyfilmapp.home.data.network

import com.jle.monkeyfilmapp.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MediaService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMedia(filter: String) : String {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MediaClient::class.java).getMedia(filter)
            response.body()?.data ?: ""
        }
    }
}