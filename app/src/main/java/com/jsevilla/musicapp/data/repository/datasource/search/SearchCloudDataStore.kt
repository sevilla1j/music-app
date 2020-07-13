package com.jsevilla.musicapp.data.repository.datasource.search

import com.jsevilla.musicapp.data.entity.ApiEntity
import com.jsevilla.musicapp.data.net.service.ISearchService

internal class SearchCloudDataStore(
    private val service: ISearchService
) : SearchDataStore {

    override suspend fun getSearch(search: String?, mediaType: String?, limit: Int?): ApiEntity {
        return service.getSearch(search, mediaType, limit)
    }
}
