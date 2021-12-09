package com.deuvox.deuvoxapp.feature.register.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.feature.register.RegisterActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [RegisterModule::class])
@PerActivity
interface RegisterComponent {
    fun inject(registerActivity: RegisterActivity)
}