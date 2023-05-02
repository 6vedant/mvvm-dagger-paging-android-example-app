package com.vedantjha.mvvmdaggerdemo2.di.modules

import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(
    includes = [
        AndroidInjectionModule::class
    ]
)
class AppModule