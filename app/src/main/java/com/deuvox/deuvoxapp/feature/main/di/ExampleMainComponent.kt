package com.deuvox.deuvoxapp.feature.main.di

import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.di.component.AppComponent
import com.deuvox.deuvoxapp.feature.main.ExampleMainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ExampleMainModule::class])
@PerActivity
interface ExampleMainComponent {
    fun inject(mainActivity: ExampleMainActivity)
}