package com.deuvox.deuvoxapp.di.component

import com.deuvox.deuvoxapp.App
import com.deuvox.deuvoxapp.di.module.HttpNetworkModule
import com.deuvox.deuvoxapp.di.module.ViewModelFactoryModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, HttpNetworkModule::class])
interface AppComponent {
    fun inject(app: App)
}