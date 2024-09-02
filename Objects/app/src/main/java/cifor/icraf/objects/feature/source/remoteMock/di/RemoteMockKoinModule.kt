package cifor.icraf.objects.feature.source.remoteMock.di

import cifor.icraf.objects.feature.source.remoteMock.source.RemoteMockSource
import cifor.icraf.objects.feature.source.remoteMock.source.RemoteMockSourceImplementation
import okhttp3.OkHttpClient
import org.koin.dsl.module

val remoteMockKoinModule = module {

    single<OkHttpClient> {
        OkHttpClient()
    }

    single<RemoteMockSource> {
        RemoteMockSourceImplementation(
            ioDispatcher = get(),
            okHttpClient = get(),
            objectsDao = get()
        )
    }

}