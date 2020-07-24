package com.jsevilla.musicapp.presentation.feature.album.di

import com.jsevilla.musicapp.domain.interactor.AlbumUseCase
import com.jsevilla.musicapp.domain.repository.AlbumRepository
import com.jsevilla.musicapp.presentation.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class AlbumModule {
    @Provides
    @PerActivity
    fun providesAlbumUseCase(albumRepository: AlbumRepository): AlbumUseCase {
        return AlbumUseCase(albumRepository)
    }
}
