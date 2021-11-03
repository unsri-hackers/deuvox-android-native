package com.example.mvvm_therightway.feature.main.di

import com.example.mvvm_therightway.base.anotation.scope.PerActivity
import com.example.mvvm_therightway.di.component.AppComponent
import com.example.mvvm_therightway.feature.main.ExampleMainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ExampleMainModule::class])
@PerActivity
interface ExampleMainComponent {
    fun inject(mainActivity: ExampleMainActivity)
}