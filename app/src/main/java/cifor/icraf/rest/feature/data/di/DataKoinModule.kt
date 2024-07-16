package cifor.icraf.rest.feature.data.di

import cifor.icraf.rest.feature.data.repository.RestRepository
import cifor.icraf.rest.feature.data.repository.RestRepositoryImplementation
import cifor.icraf.rest.feature.source.local.di.localSourceKoinModule
import cifor.icraf.rest.feature.source.remote.di.remoteSourceKoinModule
import org.koin.dsl.module

val dataKoinModule = module {

    single<RestRepository> {
        RestRepositoryImplementation(
            restDao = get(),
            restApiService = get(),
            ioDispatcher = get()
        )
    }

    includes(listOf(remoteSourceKoinModule, localSourceKoinModule))

}