package com.jle.monkeyfilmapp.register.data.network.response

import com.google.gson.annotations.SerializedName

data class UploadImageResponse(@SerializedName("status") val status: String,
                               @SerializedName("data") val data: String)
