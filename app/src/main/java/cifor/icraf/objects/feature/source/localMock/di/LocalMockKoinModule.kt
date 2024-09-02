package cifor.icraf.objects.feature.source.localMock.di

import cifor.icraf.objects.feature.source.localMock.source.MockSource
import cifor.icraf.objects.feature.source.localMock.source.MockSourceImplementation
import org.koin.dsl.module

val mockSourceKoinModule = module {
    single<MockSource> {
        MockSourceImplementation(
            ioDispatcher = get()
        )
    }
}