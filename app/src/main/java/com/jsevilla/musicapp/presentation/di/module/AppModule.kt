package com.jsevilla.musicapp.presentation.di.module

import android.content.Context
import com.jsevilla.musicapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private var app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}
