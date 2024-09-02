package cifor.icraf.objects.feature.source.remoteMock.downloader

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class AndroidDownloader(
    private val context: Context
) : Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadJsonFile(url: String): Long {
        val downloadRequest = DownloadManager.Request(url.toUri())
            .setMimeType("application/json")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("countries.json")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "countries.json")
        return downloadManager.enqueue(downloadRequest)
    }

}