package com.jsevilla.musicapp.domain.repository

import com.jsevilla.musicapp.domain.entity.Music

interface HomeRepository {
    suspend fun getListData(): List<Music>
}
