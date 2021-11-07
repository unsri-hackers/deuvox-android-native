package com.example.deuvox.di.component

import com.example.deuvox.App
import com.example.deuvox.di.module.HttpNetworkModule
import com.example.deuvox.di.module.ViewModelFactoryModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, HttpNetworkModule::class])
interface AppComponent {
    fun inject(app: App)
}