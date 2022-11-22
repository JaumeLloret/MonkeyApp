package com.jle.monkeyfilmapp.home.domain

import com.jle.monkeyfilmapp.home.data.MediaRepository

class MediaUseCase {
    val repository = MediaRepository()

    suspend operator fun invoke(filter: String): String {
        return repository.getMedia(filter)
    }
}