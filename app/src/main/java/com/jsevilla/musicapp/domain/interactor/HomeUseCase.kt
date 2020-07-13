package com.jsevilla.musicapp.domain.interactor

import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase
@Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun getListData(): List<Music> {
        return homeRepository.getListData()
    }
}
