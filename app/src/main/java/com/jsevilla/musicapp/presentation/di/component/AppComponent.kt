package com.jsevilla.musicapp.presentation.di.component

import android.content.Context
import com.jsevilla.musicapp.domain.repository.HomeRepository
import com.jsevilla.musicapp.presentation.base.BaseActivity
import com.jsevilla.musicapp.presentation.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: BaseActivity)

    fun context(): Context

    fun homeRepository(): HomeRepository
}