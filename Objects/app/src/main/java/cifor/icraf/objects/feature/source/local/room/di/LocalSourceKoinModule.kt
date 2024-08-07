package cifor.icraf.objects.feature.source.local.room.di

import androidx.room.Room
import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.database.ObjectsDatabase
import cifor.icraf.objects.feature.source.local.room.source.LocalSource
import cifor.icraf.objects.feature.source.local.room.source.LocalSourceImplementation
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localSourceKoinModule = module {

    single<ObjectsDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = ObjectsDatabase::class.java,
            name = "RestDatabase"
        ).build()
    }

    single<ObjectsDao> {
        get<ObjectsDatabase>().objectsDao()
    }

    single<LocalSource> {
        LocalSourceImplementation(
            objectsDao = get(),
            ioDispatcher = get()
        )
    }

}