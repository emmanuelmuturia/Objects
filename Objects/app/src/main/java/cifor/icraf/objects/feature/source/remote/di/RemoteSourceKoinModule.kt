package cifor.icraf.objects.feature.source.remote.di

import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import cifor.icraf.objects.feature.source.remote.source.RemoteSourceImplementation
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val remoteSourceKoinModule = module {

    single<CoroutineDispatcher> {
        Dispatchers.IO
    }

    single<Retrofit> {
        val json = Json {
            coerceInputValues = true
            ignoreUnknownKeys = true
        }
        Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory(contentType = "application/json".toMediaType())
            )
            // .baseUrl("https://api.restful-api.dev/") Insert the Base URL of Muhammad's REST API...
            .build()
    }

    single<ObjectsApi> {
        get<Retrofit>().create(ObjectsApi::class.java)
    }

    single<RemoteSource> {
        RemoteSourceImplementation(
            objectsApi = get(),
            ioDispatcher = get(),
            objectsDao = get()
        )
    }

}