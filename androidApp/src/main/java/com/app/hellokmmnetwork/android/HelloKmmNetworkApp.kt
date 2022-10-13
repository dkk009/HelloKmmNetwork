package com.app.hellokmmnetwork.android

import android.app.Application
import com.app.hellokmmnetwork.android.di.appModule
import com.app.hellokmmnetwork.di.initKoin
import org.koin.android.ext.koin.androidContext

class HelloKmmNetworkApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@HelloKmmNetworkApp)
            modules(appModule)
        }
    }
}