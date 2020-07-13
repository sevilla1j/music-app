package com.jsevilla.musicapp.data.repository.datasource.home

import com.jsevilla.musicapp.data.entity.ApiEntity
import com.jsevilla.musicapp.data.net.service.IHomeService

internal class HomeCloudDataStore(
    private val service: IHomeService
) : HomeDataStore {
    override suspend fun getListData(): ApiEntity {
        return service.getListData()
    }
}
