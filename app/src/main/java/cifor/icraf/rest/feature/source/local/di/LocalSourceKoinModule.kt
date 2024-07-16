package cifor.icraf.rest.feature.source.local.di

import androidx.room.Room
import cifor.icraf.rest.feature.source.local.dao.RestDao
import cifor.icraf.rest.feature.source.local.database.RestDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localSourceKoinModule = module {

    single<RestDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = RestDatabase::class.java,
            name = "RestDatabase"
        ).build()
    }

    single<RestDao> {
        get<RestDatabase>().restDao()
    }

}