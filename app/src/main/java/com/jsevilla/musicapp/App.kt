package com.jsevilla.musicapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.component.DaggerAppComponent
import com.jsevilla.musicapp.presentation.di.module.AppModule


class App : MultiDexApplication() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        if (instance == null)
            instance = this
        init()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun init() {
        initializeInjector()
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        var instance: App? = null
            private set
    }
}
