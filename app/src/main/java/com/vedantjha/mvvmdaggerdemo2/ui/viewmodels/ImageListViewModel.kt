package com.vedantjha.mvvmdaggerdemo2.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.vedantjha.mvvmdaggerdemo2.data.model.ImageResponse
import com.vedantjha.mvvmdaggerdemo2.data.repository.APIRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageListViewModel @Inject constructor(private val repository: APIRepository) : ViewModel() {
    private var currentResult: Flow<PagingData<ImageResponse>>? = null

    fun getImages(): Flow<PagingData<ImageResponse>> {
        val order = listOf("latest", "random", "popular").random()
        val newResult: Flow<PagingData<ImageResponse>> = repository.getImages(order)
        currentResult = newResult
        return newResult
    }

}