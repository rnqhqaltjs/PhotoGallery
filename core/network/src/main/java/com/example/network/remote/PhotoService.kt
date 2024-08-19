package com.example.network.remote

import com.example.network.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<PhotoResponse>

    @GET("photos/{id}")
    suspend fun getPhotoDetail(@Path("id") id: String): PhotoResponse

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("count") count: Int
    ): List<PhotoResponse>
}