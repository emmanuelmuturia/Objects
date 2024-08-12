package cifor.icraf.objects.feature.source.mock.di

import cifor.icraf.objects.feature.source.mock.source.MockSource
import cifor.icraf.objects.feature.source.mock.source.MockSourceImplementation
import org.koin.dsl.module

val mockSourceKoinModule = module {
    single<MockSource> {
        MockSourceImplementation(
            ioDispatcher = get()
        )
    }
}