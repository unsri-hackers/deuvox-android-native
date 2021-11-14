package com.deuvox.deuvoxapp

import android.app.Application
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.di.component.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    var appComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        injectApplication()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun injectApplication() {
        appComponent = DaggerAppComponent.builder().build()
        appComponent?.run {
            inject(this@App)
        }
    }
}