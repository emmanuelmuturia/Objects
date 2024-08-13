package cifor.icraf.objects.feature.data.di

import cifor.icraf.objects.feature.data.repository.ObjectsRepository
import cifor.icraf.objects.feature.data.repository.ObjectsRepositoryImplementation
import cifor.icraf.objects.feature.source.local.di.localSourceKoinModule
import cifor.icraf.objects.feature.source.mock.di.mockSourceKoinModule
import cifor.icraf.objects.feature.source.remote.di.remoteSourceKoinModule
import org.koin.dsl.module

val dataKoinModule = module {

    single<ObjectsRepository> {
        ObjectsRepositoryImplementation(
            ioDispatcher = get(),
            //localSource = get(),
            mockSource = get()
        )
    }

    includes(module = listOf(
        remoteSourceKoinModule,
        localSourceKoinModule,
        mockSourceKoinModule))

}