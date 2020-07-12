package com.jsevilla.musicapp.presentation.di.component

import android.app.Activity
import com.jsevilla.musicapp.presentation.di.PerActivity
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}
