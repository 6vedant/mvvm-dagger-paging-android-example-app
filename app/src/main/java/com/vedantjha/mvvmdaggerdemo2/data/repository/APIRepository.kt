package com.vedantjha.mvvmdaggerdemo2.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.vedantjha.mvvmdaggerdemo2.api.APIService
import com.vedantjha.mvvmdaggerdemo2.data.datasource.ImageDataSource
import com.vedantjha.mvvmdaggerdemo2.utils.LOAD_SIZE
import javax.inject.Inject

class APIRepository @Inject constructor(private val apiService: APIService) {
    fun getImages(orderBy: String) = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = LOAD_SIZE),
        pagingSourceFactory = {
            ImageDataSource(apiService, orderBy)
        }
    ).flow
}