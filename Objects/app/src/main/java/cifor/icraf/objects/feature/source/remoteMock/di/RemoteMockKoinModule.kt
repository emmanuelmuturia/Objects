package cifor.icraf.objects.feature.source.remoteMock.di

import cifor.icraf.objects.feature.source.remoteMock.source.RemoteMockSource
import cifor.icraf.objects.feature.source.remoteMock.source.RemoteMockSourceImplementation
import org.koin.dsl.module

val remoteMockKoinModule = module {
    single<RemoteMockSource> {
        RemoteMockSourceImplementation(
            ioDispatcher = get()
        )
    }
}