package com.example.deuvox.feature.main.di

import androidx.lifecycle.ViewModel
import com.example.deuvox.base.anotation.scope.PerActivity
import com.example.deuvox.base.anotation.viewmodel.ViewModelKey
import com.example.deuvox.feature.main.ExampleMainViewModel
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