package com.jle.monkeyfilmapp.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jle.monkeyfilmapp.home.data.MediaModel

class MediaViewModel:ViewModel() {
    private val _mediaList = MutableLiveData<List<MediaModel>>()
    val mediaList : LiveData<List<MediaModel>> = _mediaList
}