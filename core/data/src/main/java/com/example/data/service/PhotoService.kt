package com.example.data.service

import com.example.data.model.PhotosResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("order_by") orderBy: String
    ): Response<List<PhotosResponseDto>>

    @GET("photos/{id}")
    suspend fun getPhotoDetails(@Path("id") id: String): Response<PhotosResponseDto>

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("count") count: Int
    ): Response<List<PhotosResponseDto>>
}