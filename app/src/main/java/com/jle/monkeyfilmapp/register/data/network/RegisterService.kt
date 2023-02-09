package com.jle.monkeyfilmapp.register.data.network

import android.util.Log
import com.jle.monkeyfilmapp.register.data.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject

class RegisterService @Inject constructor(private val registerClient: RegisterClient /*, private val multipartBody: MultipartBody.Part*/) {

    suspend fun signUp(
        phone: String,
        user: UserDTO
    ): Boolean {
        return withContext(Dispatchers.IO) {
            val response = registerClient.signUp(
                phone = phone,
                user = user
                )
            Log.i("DAM", "data: ${response.body()}")
            response.body()?.password!!.compareTo(user.password) == 0
        }
    }

   /* suspend fun uploadImage(path: String) {
        withContext(Dispatchers.IO) {
            val file = File(path)
            val response = registerClient.uploadImage(
                image = multipartBody,
                name = file.nameWithoutExtension,
                type = file.extension
            )
        }


    }*/
}