package com.jsevilla.musicapp.data.repository.datasource.search

import android.content.Context
import com.jsevilla.musicapp.data.net.service.impl.SearchService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchDataStoreFactory
@Inject
internal constructor(context: Context) {
    private val context: Context = context.applicationContext

    fun createCloudDataStore(): SearchDataStore {
        return SearchCloudDataStore(SearchService(context))
    }
}
