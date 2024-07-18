package cifor.icraf.objects.feature.source.remote.source

interface RemoteSource {

    suspend fun fetchObjects()

}