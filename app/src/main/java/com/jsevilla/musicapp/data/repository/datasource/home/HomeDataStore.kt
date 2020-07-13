package com.jsevilla.musicapp.data.repository.datasource.home

import com.jsevilla.musicapp.data.entity.ApiEntity

interface HomeDataStore {
    suspend fun getListData(): ApiEntity
}
