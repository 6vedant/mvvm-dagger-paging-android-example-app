package com.vedantjha.mvvmdaggerdemo2.di

import android.app.Application
import com.vedantjha.mvvmdaggerdemo2.MainActivity
import com.vedantjha.mvvmdaggerdemo2.MainApplication
import com.vedantjha.mvvmdaggerdemo2.di.modules.AppModule
import com.vedantjha.mvvmdaggerdemo2.di.modules.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent: AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
       @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
//
//        fun inject(activity: MainActivity)
    }
}