package com.vedantjha.mvvmdaggerdemo2.data.datasource

import com.vedantjha.mvvmdaggerdemo2.api.APIService
import javax.inject.Inject

class ImageDataSource(private val apiService: APIService, private val orderBy: String) {
}