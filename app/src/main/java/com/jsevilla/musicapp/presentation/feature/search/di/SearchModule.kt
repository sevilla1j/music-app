package com.jsevilla.musicapp.presentation.feature.search.di

import com.jsevilla.musicapp.domain.interactor.SearchUseCase
import com.jsevilla.musicapp.domain.repository.SearchRepository
import com.jsevilla.musicapp.presentation.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @Provides
    @PerActivity
    fun providesSearchModule(searchRepository: SearchRepository): SearchUseCase {
        return SearchUseCase(searchRepository)
    }
}
