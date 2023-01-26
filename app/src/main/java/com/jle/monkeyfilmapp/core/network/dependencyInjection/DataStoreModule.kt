package com.jle.monkeyfilmapp.core.network.dependencyInjection


import android.content.Context
import com.jle.monkeyfilmapp.login.data.db.IUserPreferences
import com.jle.monkeyfilmapp.login.data.db.UserPreferencesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStoreUserPreferences(@ApplicationContext context: Context): Context {
        return context
    }
}