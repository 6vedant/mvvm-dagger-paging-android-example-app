package com.vedantjha.mvvmdaggerdemo2.api

import com.vedantjha.mvvmdaggerdemo2.data.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("photos")
    suspend fun getImages(
        @Query("order_by") orderBy: String,
        @Query("page") page: Int,
        @Query("per_page") limit: Int
    ): List<ImageResponse>
}