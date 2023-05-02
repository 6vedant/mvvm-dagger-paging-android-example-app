package com.vedantjha.mvvmdaggerdemo2.di.modules


import com.vedantjha.mvvmdaggerdemo2.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    abstract fun contributeMainActivity(): MainActivity
}
