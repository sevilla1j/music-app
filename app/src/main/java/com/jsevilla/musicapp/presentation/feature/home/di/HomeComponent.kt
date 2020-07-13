package com.jsevilla.musicapp.presentation.feature.home.di

import com.jsevilla.musicapp.presentation.di.PerActivity
import com.jsevilla.musicapp.presentation.di.component.ActivityComponent
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import com.jsevilla.musicapp.presentation.feature.home.HomeFragment
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, HomeModule::class]
)
interface HomeComponent : ActivityComponent {
    fun inject(homeFragment: HomeFragment?)
}
