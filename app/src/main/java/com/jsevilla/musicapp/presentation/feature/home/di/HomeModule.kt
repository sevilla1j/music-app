package com.jsevilla.musicapp.presentation.feature.home.di

import com.jsevilla.musicapp.domain.interactor.HomeUseCase
import com.jsevilla.musicapp.domain.repository.HomeRepository
import com.jsevilla.musicapp.presentation.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    @PerActivity
    fun providesHomeUseCase(homeRepository: HomeRepository): HomeUseCase {
        return HomeUseCase(homeRepository)
    }
}

