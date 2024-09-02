package cifor.icraf.objects.feature.source.remote.source

fun interface RemoteSource {

    suspend fun fetchAllCountries()

}
