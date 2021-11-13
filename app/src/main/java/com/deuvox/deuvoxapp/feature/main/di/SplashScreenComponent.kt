package com.deuvox.deuvoxapp.feature.main.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.feature.main.splashscreen.SplashScreenActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [SplashScreenModule::class])
@PerActivity
interface SplashScreenComponent {
    fun inject(mainActivity: SplashScreenActivity)
}