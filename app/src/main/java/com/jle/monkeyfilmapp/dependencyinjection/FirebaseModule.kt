package com.jle.monkeyfilmapp.dependencyinjection

import com.jle.monkeyfilmapp.login.data.network.LoginClient
import com.jle.monkeyfilmapp.register.data.network.RegisterClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    @Provides
    @Singleton
    fun getInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
            request.addHeader("Accept", "application/json")
            val actualRequest = request.build()
            it.proceed(actualRequest)
        }
    }

    @Singleton
    @Provides
    fun getHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideRealTimeDatabaseFirebase(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://monkeyfilmapp-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideRealTimeDatabaseFirebaseLoginClient(retrofit: Retrofit) : LoginClient {
        return retrofit.create(LoginClient::class.java)
    }

    @Singleton
    @Provides
    fun provideRealTimeDatabaseFirebaseRegisterClient(retrofit: Retrofit) : RegisterClient {
        return retrofit.create(RegisterClient::class.java)
    }
/*
    @Singleton
    @Provides
    fun provideRequestBody(file: File) : RequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)

    @Singleton
    @Provides
    fun provideMultipartBody(file: File, requestBody: RequestBody) : MultipartBody.Part = MultipartBody.Part.createFormData("picture", file.name, requestBody)*/
}