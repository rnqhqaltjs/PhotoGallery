package com.example.network.remote

import com.example.network.model.ResponsePhotosDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<ResponsePhotosDto>

    @GET("photos/{id}")
    suspend fun getPhotoDetail(@Path("id") id: String): ResponsePhotosDto

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("count") count: Int
    ): List<ResponsePhotosDto>
}