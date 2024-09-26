package com.example.data.repository

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import com.example.domain.repository.DownloadRepository
import javax.inject.Inject

class DownloadRepositoryImpl
    @Inject
    constructor(
        context: Context,
    ) : DownloadRepository {
        private val downloadManager = context.getSystemService(DownloadManager::class.java)

        override fun downloadPhoto(photoUrl: String): Long {
            val request =
                DownloadManager
                    .Request(photoUrl.toUri())
                    .setMimeType("image/jpeg")
                    .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setTitle("${System.currentTimeMillis()}.jpg")
                    .addRequestHeader(
                        "Authorization",
                        "Client-ID eOfYAPKwA61_W94eO7nOm13LTq4bRes2HcPMY9UFpwk",
                    ).setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOWNLOADS,
                        "${System.currentTimeMillis()}.jpg",
                    )
            return downloadManager.enqueue(request)
        }
    }
