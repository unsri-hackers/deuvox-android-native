package com.example.mvvm_therightway

import android.app.Application
import com.example.mvvm_therightway.di.component.AppComponent
import com.example.mvvm_therightway.di.component.DaggerAppComponent

class App : Application() {
    var appComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        injectApplication()
    }

    private fun injectApplication() {
        appComponent = DaggerAppComponent.builder().build()
        appComponent?.run {
            inject(this@App)
        }
    }
}