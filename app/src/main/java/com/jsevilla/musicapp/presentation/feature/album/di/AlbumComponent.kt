package com.jsevilla.musicapp.presentation.feature.album.di

import com.jsevilla.musicapp.presentation.di.PerActivity
import com.jsevilla.musicapp.presentation.di.component.ActivityComponent
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import com.jsevilla.musicapp.presentation.feature.album.AlbumFragment
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, AlbumModule::class]
)
interface AlbumComponent : ActivityComponent {
    fun inject(albumFragment: AlbumFragment?)
}
