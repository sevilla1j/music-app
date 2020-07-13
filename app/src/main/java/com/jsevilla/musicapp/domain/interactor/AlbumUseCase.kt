package com.jsevilla.musicapp.domain.interactor

import com.jsevilla.musicapp.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumUseCase
@Inject constructor(
    private val albumRepository: AlbumRepository
) {
}