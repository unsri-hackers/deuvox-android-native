package com.deuvox.deuvoxapp.feature.register.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [RegisterModule::class])
@PerActivity
interface RegisterComponent {
    // TODO: Inject Activity here!!!
    // fun inject(registerActivity: RegisterActivity)
}