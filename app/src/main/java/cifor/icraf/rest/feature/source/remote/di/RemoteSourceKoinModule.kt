package cifor.icraf.rest.feature.source.remote.di

import cifor.icraf.rest.feature.source.remote.service.RestApiService
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
        Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory(contentType = "application/json".toMediaType())
            ).baseUrl("https://api.restful-api.dev/")
            .build()
    }

    single<RestApiService> {
        get<Retrofit>().create(RestApiService::class.java)
    }

}