package com.jsevilla.musicapp.data.repository.datasource.home

import android.content.Context
import com.jsevilla.musicapp.data.net.service.impl.HomeService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDataStoreFactory
@Inject
internal constructor(context: Context) {
    private val context: Context = context.applicationContext

    fun createCloudDataStore(token: String?): HomeDataStore {
        return HomeCloudDataStore(HomeService(context))
    }
}
