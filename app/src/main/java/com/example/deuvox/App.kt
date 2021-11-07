package com.example.deuvox

import android.app.Application
import com.example.deuvox.di.component.AppComponent
import com.example.deuvox.di.component.DaggerAppComponent

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