package com.deuvox.di

import com.deuvox.auth.remote.AuthRemoteRepository
import com.deuvox.auth.remote.AuthService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideAuthRemoteRepository(service: AuthService): AuthRemoteRepository {
        return AuthRemoteRepository(service)
    }

}