package com.example.photogallery.receiver

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class DownloadCompletedReceiver : BroadcastReceiver() {
    private lateinit var downloadManager: DownloadManager

    override fun onReceive(
        context: Context?,
        intent: Intent?,
    ) {
        downloadManager = context?.getSystemService(DownloadManager::class.java)!!
        if (intent?.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
            if (id != -1L) {
                Log.d("DownloadReceiver", "Download completed with ID: $id")
            } else {
                Log.d("DownloadReceiver", "Download ID is invalid.")
            }
        }
    }
}
