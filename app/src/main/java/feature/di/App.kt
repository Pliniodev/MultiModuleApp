package feature.di

import android.app.Application
import feature.di.exampleModule
import feature.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@App)

            modules(
                networkCoreModule,
                dataModule,
                domainModule,
                databaseModule,
                homeModule,
                exampleModule,
            )
        }
    }
}