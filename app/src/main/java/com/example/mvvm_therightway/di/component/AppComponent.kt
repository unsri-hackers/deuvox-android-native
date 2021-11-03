package com.example.mvvm_therightway.di.component

import com.example.mvvm_therightway.App
import com.example.mvvm_therightway.di.module.HttpNetworkModule
import com.example.mvvm_therightway.di.module.ViewModelFactoryModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, HttpNetworkModule::class])
interface AppComponent {
    fun inject(app: App)
}