package com.jle.monkeyfilmapp.home.data

import androidx.annotation.DrawableRes

data class MediaModel(
    var id: Int,
    var title: String,
    var description: String,
    var catel: Int,
    var score: Int,
    var favorite: Boolean = false,
    var genre: List<String>,
    var category: String
)
