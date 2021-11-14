package com.deuvox.deuvoxapp.di.module

import com.deuvox.auth.AuthRepositoryImpl
import com.deuvox.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

}