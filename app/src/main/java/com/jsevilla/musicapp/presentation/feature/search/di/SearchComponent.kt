package com.jsevilla.musicapp.presentation.feature.search.di

import com.jsevilla.musicapp.presentation.di.PerActivity
import com.jsevilla.musicapp.presentation.di.component.ActivityComponent
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import com.jsevilla.musicapp.presentation.feature.search.SearchFragment
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, SearchModule::class]
)
interface SearchComponent : ActivityComponent {
    fun inject(searchFragment: SearchFragment?)
}
