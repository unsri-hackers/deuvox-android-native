package com.deuvox.deuvoxapp

import android.app.Application
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.di.component.DaggerAppComponent

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