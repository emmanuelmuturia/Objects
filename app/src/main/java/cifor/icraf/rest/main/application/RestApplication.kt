package cifor.icraf.rest.main.application

import android.app.Application
import com.squareup.leakcanary.core.BuildConfig
import org.koin.core.context.startKoin
import timber.log.Timber

class RestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(tree = Timber.DebugTree())
        startKoin {
            modules(modules = listOf())
        }
    }

}