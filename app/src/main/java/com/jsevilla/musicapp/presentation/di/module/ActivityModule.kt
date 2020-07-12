package com.jsevilla.musicapp.presentation.di.module

import android.app.Activity
import com.jsevilla.musicapp.presentation.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @PerActivity
    fun provideActivity(): Activity {
        return activity
    }
}
