package com.example.deuvox.feature.main.di

import com.example.deuvox.base.anotation.scope.PerActivity
import com.example.deuvox.di.component.AppComponent
import com.example.deuvox.feature.main.ExampleMainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ExampleMainModule::class])
@PerActivity
interface ExampleMainComponent {
    fun inject(mainActivity: ExampleMainActivity)
}