package com.jle.monkeyfilmapp.core.network.dependencyInjection

import com.jle.monkeyfilmapp.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    @Singleton
    @Provides
    fun provideRealTimeDatabaseFirebase(): Retrofit {
        return Retrofit.Builder().baseUrl("https://monkeyfilmapp-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideRealTimeDatabaseFirebaseLoginClient(retrofit: Retrofit):LoginClient {
        return retrofit.create(LoginClient::class.java)
    }
}