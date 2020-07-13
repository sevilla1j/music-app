package com.jsevilla.musicapp.domain.interactor

import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase
@Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun getSearch(text: String): List<Music> {
        return searchRepository.getSearch(text)
    }
}
