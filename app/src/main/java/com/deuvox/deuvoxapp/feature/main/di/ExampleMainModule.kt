package com.deuvox.deuvoxapp.feature.main.di

import androidx.lifecycle.ViewModel
import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.base.anotation.viewmodel.ViewModelKey
import com.deuvox.deuvoxapp.feature.main.ExampleMainViewModel
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