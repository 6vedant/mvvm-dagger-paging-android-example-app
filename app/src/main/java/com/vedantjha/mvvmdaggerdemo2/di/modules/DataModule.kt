package com.vedantjha.mvvmdaggerdemo2.di.modules

import com.vedantjha.mvvmdaggerdemo2.api.APIService
import com.vedantjha.mvvmdaggerdemo2.data.repository.APIRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRepository(apiService: APIService): APIRepository {
        return APIRepository(apiService)
    }
}
