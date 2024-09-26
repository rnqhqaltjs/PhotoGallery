package com.example.domain.repository

interface DownloadRepository {
    fun downloadPhoto(photoUrl: String): Long
}
