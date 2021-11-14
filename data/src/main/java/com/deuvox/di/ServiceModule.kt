package com.deuvox.di

import com.deuvox.auth.remote.AuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideAuthService(builder: Retrofit.Builder): AuthService {
        return builder.build().create(AuthService::class.java)
    }

}