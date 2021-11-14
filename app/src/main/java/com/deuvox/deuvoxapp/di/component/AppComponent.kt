package com.deuvox.deuvoxapp.di.component

import com.deuvox.deuvoxapp.App
import com.deuvox.deuvoxapp.di.module.RepositoryModule
import com.deuvox.deuvoxapp.di.module.ViewModelFactoryModule
import com.deuvox.di.NetworkModule
import com.deuvox.di.RemoteModule
import com.deuvox.di.ServiceModule
import com.deuvox.domain.auth.AuthRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelFactoryModule::class,
        NetworkModule::class,
        ServiceModule::class,
        RemoteModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun authRepo(): AuthRepository
}