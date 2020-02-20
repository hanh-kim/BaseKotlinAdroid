package com.base.mvvmbasekotlin.di.module

import com.base.mvvmbasekotlin.ui.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun bindSplashFragment(): SplashFragment
}