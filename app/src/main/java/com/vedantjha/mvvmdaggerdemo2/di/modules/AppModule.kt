package com.vedantjha.mvvmdaggerdemo2.di.modules

import android.net.Network
import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(
    includes = [
        DataModule::class,
        NetworkModule::class,
        ViewModelModule::class,
    ]
)
class AppModule