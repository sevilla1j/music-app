package com.jsevilla.musicapp.data.repository

import com.jsevilla.musicapp.data.mapper.SearchDataMapper
import com.jsevilla.musicapp.data.repository.datasource.search.SearchDataStoreFactory
import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.domain.repository.SearchRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchDataRepository
@Inject
internal constructor(
    private val searchDataStoreFactory: SearchDataStoreFactory,
    private val searchDataMapper: SearchDataMapper
) : SearchRepository {

    override suspend fun getSearch(text: String): List<Music> {
        val dataList = this.searchDataStoreFactory.createCloudDataStore()
        return coroutineScope {
            async {
                searchDataMapper.transformList(dataList.getSearch(text, "music", 20).results)
            }
        }.await()
    }
}