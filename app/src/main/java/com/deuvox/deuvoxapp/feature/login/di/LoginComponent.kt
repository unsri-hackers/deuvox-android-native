package com.deuvox.deuvoxapp.feature.login.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [LoginModule::class])
@PerActivity
interface LoginComponent {
    // TODO (Ricky): DRP-007 - Inject Activity
    // fun inject(loginActivity: LoginActivity)
}