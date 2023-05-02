package com.vedantjha.mvvmdaggerdemo2.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vedantjha.mvvmdaggerdemo2.api.APIService
import com.vedantjha.mvvmdaggerdemo2.data.model.ImageResponse
import com.vedantjha.mvvmdaggerdemo2.utils.STARTING_PAGE
import java.io.IOException
import javax.inject.Inject

class ImageDataSource(private val apiService: APIService, private val orderBy: String) :
    PagingSource<Int, ImageResponse>() {
    override fun getRefreshKey(state: PagingState<Int, ImageResponse>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageResponse> {
        val page = params.key ?: STARTING_PAGE
        return try {
            val data = apiService.getImages(orderBy, page, params.loadSize)
            LoadResult.Page(
                data = data,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (throwable: Throwable) {
            var exception = throwable
            exception = if (throwable is IOException) {
                IOException("Please check your internet connection")
            } else {
                java.lang.Exception("An error occurred!")

            }
            LoadResult.Error(exception)
        }
    }
}