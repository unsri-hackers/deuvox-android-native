package com.deuvox.deuvoxapp.feature.login.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.feature.login.LoginActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [LoginModule::class])
@PerActivity
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}