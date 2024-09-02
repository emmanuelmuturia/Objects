package cifor.icraf.objects.feature.source.local.di

import androidx.room.Room
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.database.ObjectsDatabase
import cifor.icraf.objects.feature.source.local.source.LocalSource
import cifor.icraf.objects.feature.source.local.source.LocalSourceImplementation
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localSourceKoinModule = module {

    single<ObjectsDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = ObjectsDatabase::class.java,
            name = "CountriesDatabase"
        ).build()
    }

    single<ObjectsDao> {
        get<ObjectsDatabase>().objectsDao()
    }

    single<LocalSource> {
        LocalSourceImplementation(
            objectsDao = get(),
            ioDispatcher = get(),
            //remoteSource = get(),
            //mockSource = get(),
            remoteMockSource = get()
        )
    }

}