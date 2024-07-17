package cifor.icraf.objects.main.application

import android.app.Application
import cifor.icraf.objects.feature.ui.di.uiKoinModule
import com.squareup.leakcanary.core.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class ObjectsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(tree = Timber.DebugTree())
        startKoin {
            androidContext(androidContext = applicationContext)
            modules(modules = listOf(uiKoinModule))
        }
    }

}