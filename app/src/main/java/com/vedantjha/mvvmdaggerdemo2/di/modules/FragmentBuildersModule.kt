package com.vedantjha.mvvmdaggerdemo2.di.modules


import com.vedantjha.mvvmdaggerdemo2.ui.fragment.ImagesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeImagesListFragment(): ImagesListFragment
}
