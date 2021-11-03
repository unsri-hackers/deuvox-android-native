package com.example.mvvm_therightway.feature.main.di

import androidx.lifecycle.ViewModel
import com.example.mvvm_therightway.base.anotation.scope.PerActivity
import com.example.mvvm_therightway.base.anotation.viewmodel.ViewModelKey
import com.example.mvvm_therightway.feature.main.ExampleMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ExampleMainModule {
    @Binds
    @IntoMap
    @ViewModelKey(ExampleMainViewModel::class)
    @PerActivity
    abstract fun exampleMainViewModel(viewModel: ExampleMainViewModel): ViewModel
}