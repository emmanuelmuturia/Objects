package cifor.icraf.objects.feature.source.remoteMock.downloader

interface Downloader {
    fun downloadJsonFile(url: String): Long
}