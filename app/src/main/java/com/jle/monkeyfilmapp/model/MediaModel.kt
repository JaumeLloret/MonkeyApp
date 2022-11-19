package com.jle.monkeyfilmapp.model

import androidx.annotation.DrawableRes

data class MediaModel(
    var id: Int,
    var title: String,
    var description: String,
    @DrawableRes var catel: Int,
    var score: Int,
    var favorite: Boolean = false,
    var genre: List<String>,
    var category: String
)
