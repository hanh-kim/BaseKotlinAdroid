package com.base.mvvmbasekotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.base.mvvmbasekotlin.di.ViewModelFactory
import com.base.mvvmbasekotlin.ui.SplashViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
