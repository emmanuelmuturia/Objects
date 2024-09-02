package cifor.icraf.objects.feature.source.remoteMock.source

fun interface RemoteMockSource {

    suspend fun getRemoteMockCountries()

}