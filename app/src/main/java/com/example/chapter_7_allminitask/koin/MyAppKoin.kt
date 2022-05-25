package com.example.chapter_7_allminitask.koin

import android.app.Application
import com.example.chapter_7_allminitask.koin.di.appModuleKoin
import com.example.chapter_7_allminitask.koin.di.repositoryModuleKoin
import com.example.chapter_7_allminitask.koin.di.viewModelModuleKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyAppKoin : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyAppKoin)
            // declare modules
            modules(listOf(appModuleKoin, repositoryModuleKoin, viewModelModuleKoin ))
        }
    }

}