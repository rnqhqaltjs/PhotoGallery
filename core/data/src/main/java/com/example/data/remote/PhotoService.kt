package com.example.data.remote

import com.example.data.model.ResponsePhotosDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<ResponsePhotosDto>>

    @GET("photos/{id}")
    suspend fun getPhotoDetails(@Path("id") id: String): Response<ResponsePhotosDto>

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("count") count: Int
    ): Response<List<ResponsePhotosDto>>
}