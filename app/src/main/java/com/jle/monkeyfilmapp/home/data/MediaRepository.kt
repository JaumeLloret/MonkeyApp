package com.jle.monkeyfilmapp.home.data

import com.jle.monkeyfilmapp.home.data.network.MediaService

class MediaRepository {
    private val api = MediaService()

    suspend fun getMedia(filter: String): String {
        return api.getMedia(filter)
    }
}