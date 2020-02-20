package com.base.mvvmbasekotlin.di.module


import com.base.mvvmbasekotlin.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
