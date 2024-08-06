package cifor.icraf.objects.feature.data.di

import cifor.icraf.objects.feature.data.repository.ObjectsRepository
import cifor.icraf.objects.feature.data.repository.ObjectsRepositoryImplementation
import cifor.icraf.objects.feature.source.local.room.di.localSourceKoinModule
import cifor.icraf.objects.feature.source.remote.di.remoteSourceKoinModule
import org.koin.dsl.module

val dataKoinModule = module {

    single<ObjectsRepository> {
        ObjectsRepositoryImplementation(
            localSource = get(),
            ioDispatcher = get(),
            remoteSource = get()
        )
    }

    includes(listOf(remoteSourceKoinModule, localSourceKoinModule))

}