package com.jsevilla.musicapp.data.repository.datasource.search

import com.jsevilla.musicapp.data.entity.ApiEntity

interface SearchDataStore {
    suspend fun getSearch(search: String?, mediaType: String?, limit: Int?): ApiEntity
}