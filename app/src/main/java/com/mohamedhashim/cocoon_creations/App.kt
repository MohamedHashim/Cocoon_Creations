package com.mohamedhashim.cocoon_creations

import android.app.Application
import com.mohamedhashim.cocoon_creations.mvvm.di.networkModule
import com.mohamedhashim.cocoon_creations.mvvm.di.persistenceModule
import com.mohamedhashim.cocoon_creations.mvvm.di.repositoryModule
import com.mohamedhashim.cocoon_creations.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(persistenceModule)
        }
    }
}