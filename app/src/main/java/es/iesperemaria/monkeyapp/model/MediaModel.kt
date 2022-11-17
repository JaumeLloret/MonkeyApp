package es.iesperemaria.monkeyapp.model

import androidx.annotation.DrawableRes

data class MediaModel(
    var id: Int,
    var title: String,
    var description: String,
    @DrawableRes var cartel: Int,
    var score: Int,
    var favorite: Boolean = false,
    var genre: List<String>
)
