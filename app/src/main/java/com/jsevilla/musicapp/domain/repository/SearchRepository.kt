package com.jsevilla.musicapp.domain.repository

import com.jsevilla.musicapp.domain.entity.Music

interface SearchRepository {
    suspend fun getSearch(text: String): List<Music>
}