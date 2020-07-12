package com.jsevilla.musicapp.presentation.feature.splash.di

import com.jsevilla.musicapp.presentation.di.PerActivity
import com.jsevilla.musicapp.presentation.di.component.ActivityComponent
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import com.jsevilla.musicapp.presentation.feature.splash.SplashFragment
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, SplashModule::class]
)
interface SplashComponent : ActivityComponent {
    fun inject(splashFragment: SplashFragment?)
}