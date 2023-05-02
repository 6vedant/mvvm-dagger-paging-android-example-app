package com.vedantjha.mvvmdaggerdemo2.di.modules

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRepository(): Int {
        return 1
    }
}
