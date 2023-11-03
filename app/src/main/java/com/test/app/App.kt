package com.test.app

import android.app.Application
import com.test.app.di.dataDi
import com.test.app.di.domainDi
import com.test.app.di.uiDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataDi,
                    domainDi,
                    uiDi
                )
            )
        }
    }
}