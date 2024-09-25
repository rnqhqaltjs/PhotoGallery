package com.example.network.model

import com.squareup.moshi.Json

data class PhotoResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "promoted_at")
    val promotedAt: String?,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "color")
    val color: String,
    @Json(name = "blur_hash")
    val blurHash: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "alt_description")
    val altDescription: String?,
    @Json(name = "urls")
    val urls: Urls,
    @Json(name = "links")
    val links: Links,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "liked_by_user")
    val likedByUser: Boolean,
    @Json(name = "user")
    val user: User,
) {
    data class Urls(
        @Json(name = "raw")
        val raw: String,
        @Json(name = "full")
        val full: String,
        @Json(name = "regular")
        val regular: String,
        @Json(name = "small")
        val small: String,
        @Json(name = "thumb")
        val thumb: String,
        @Json(name = "small_s3")
        val smallS3: String,
    )

    data class Links(
        @Json(name = "self")
        val self: String,
        @Json(name = "html")
        val html: String,
        @Json(name = "download")
        val download: String,
        @Json(name = "download_location")
        val downloadLocation: String,
    )

    data class User(
        @Json(name = "id")
        val id: String,
        @Json(name = "updated_at")
        val updatedAt: String,
        @Json(name = "username")
        val username: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "first_name")
        val firstName: String?,
        @Json(name = "last_name")
        val lastName: String?,
        @Json(name = "twitter_username")
        val twitterUsername: String?,
        @Json(name = "portfolio_url")
        val portfolioUrl: String?,
        @Json(name = "bio")
        val bio: String?,
        @Json(name = "location")
        val location: String?,
        @Json(name = "links")
        val links: Links,
        @Json(name = "profile_image")
        val profileImage: ProfileImage?,
        @Json(name = "instagram_username")
        val instagramUsername: String?,
        @Json(name = "total_collections")
        val totalCollections: Int,
        @Json(name = "total_likes")
        val totalLikes: Int,
        @Json(name = "total_photos")
        val totalPhotos: Int,
        @Json(name = "total_promoted_photos")
        val totalPromotedPhotos: Int,
        @Json(name = "accepted_tos")
        val acceptedTos: Boolean,
        @Json(name = "for_hire")
        val forHire: Boolean,
        @Json(name = "social")
        val social: Social,
    ) {
        data class Links(
            @Json(name = "self")
            val self: String,
            @Json(name = "html")
            val html: String,
            @Json(name = "photos")
            val photos: String,
            @Json(name = "likes")
            val likes: String,
            @Json(name = "portfolio")
            val portfolio: String,
            @Json(name = "following")
            val following: String,
            @Json(name = "followers")
            val followers: String,
        )

        data class ProfileImage(
            @Json(name = "small")
            val small: String,
            @Json(name = "medium")
            val medium: String,
            @Json(name = "large")
            val large: String,
        )

        data class Social(
            @Json(name = "instagram_username")
            val instagramUsername: String?,
            @Json(name = "portfolio_url")
            val portfolioUrl: String?,
            @Json(name = "twitter_username")
            val twitterUsername: String?,
            @Json(name = "paypal_email")
            val paypalEmail: String?,
        )
    }
}
