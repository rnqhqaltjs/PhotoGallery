package com.example.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotosResponseDto(
    @field:Json(name = "blur_hash")
    val blurHash: String?,
    @field:Json(name = "color")
    val color: String,
    @field:Json(name = "created_at")
    val createdAt: String,
    @field:Json(name = "current_user_collections")
    val currentUserCollections: List<CurrentUserCollection>,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "liked_by_user")
    val likedByUser: Boolean,
    @field:Json(name = "likes")
    val likes: Int,
    @field:Json(name = "links")
    val links: Links,
    @field:Json(name = "updated_at")
    val updatedAt: String,
    @field:Json(name = "urls")
    val urls: Urls,
    @field:Json(name = "user")
    val user: User,
    @field:Json(name = "width")
    val width: Int
) {
    @JsonClass(generateAdapter = true)
    data class CurrentUserCollection(
        @field:Json(name = "cover_photo")
        val coverPhoto: Any,
        @field:Json(name = "id")
        val id: Int,
        @field:Json(name = "last_collected_at")
        val lastCollectedAt: String,
        @field:Json(name = "published_at")
        val publishedAt: String,
        @field:Json(name = "title")
        val title: String,
        @field:Json(name = "updated_at")
        val updatedAt: String,
        @field:Json(name = "user")
        val user: Any
    )

    @JsonClass(generateAdapter = true)
    data class Links(
        @field:Json(name = "download")
        val download: String,
        @field:Json(name = "download_location")
        val downloadLocation: String,
        @field:Json(name = "html")
        val html: String,
        @field:Json(name = "self")
        val self: String
    )

    @JsonClass(generateAdapter = true)
    data class Urls(
        @field:Json(name = "full")
        val full: String,
        @field:Json(name = "raw")
        val raw: String,
        @field:Json(name = "regular")
        val regular: String,
        @field:Json(name = "small")
        val small: String,
        @field:Json(name = "thumb")
        val thumb: String
    )

    @JsonClass(generateAdapter = true)
    data class User(
        @field:Json(name = "bio")
        val bio: String?,
        @field:Json(name = "id")
        val id: String,
        @field:Json(name = "instagram_username")
        val instagramUsername: String?,
        @field:Json(name = "links")
        val links: LinksX,
        @field:Json(name = "location")
        val location: String?,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "portfolio_url")
        val portfolioUrl: String?,
        @field:Json(name = "profile_image")
        val profileImage: ProfileImage,
        @field:Json(name = "total_collections")
        val totalCollections: Int,
        @field:Json(name = "total_likes")
        val totalLikes: Int,
        @field:Json(name = "total_photos")
        val totalPhotos: Int,
        @field:Json(name = "twitter_username")
        val twitterUsername: String?,
        @field:Json(name = "username")
        val username: String
    )

    @JsonClass(generateAdapter = true)
    data class LinksX(
        @field:Json(name = "html")
        val html: String,
        @field:Json(name = "likes")
        val likes: String,
        @field:Json(name = "photos")
        val photos: String,
        @field:Json(name = "portfolio")
        val portfolio: String,
        @field:Json(name = "self")
        val self: String
    )

    @JsonClass(generateAdapter = true)
    data class ProfileImage(
        @field:Json(name = "large")
        val large: String,
        @field:Json(name = "medium")
        val medium: String,
        @field:Json(name = "small")
        val small: String
    )
}