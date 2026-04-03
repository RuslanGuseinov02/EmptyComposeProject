package com.ruslan.huseynov.emptycomposeproject

import android.app.Application
import com.ruslan.huseynov.emptycomposeproject.di.networkModule
import com.ruslan.huseynov.emptycomposeproject.di.repositoryModule
import com.ruslan.huseynov.emptycomposeproject.di.useCaseModule
import com.ruslan.huseynov.emptycomposeproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}