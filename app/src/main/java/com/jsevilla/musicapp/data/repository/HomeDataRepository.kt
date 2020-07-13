package com.jsevilla.musicapp.data.repository

import com.jsevilla.musicapp.data.mapper.HomeDataMapper
import com.jsevilla.musicapp.data.repository.datasource.home.HomeDataStoreFactory
import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.domain.repository.HomeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDataRepository
@Inject
internal constructor(
    private val homeDataStoreFactory: HomeDataStoreFactory,
    private val homeDataMapper: HomeDataMapper
) : HomeRepository {
    override suspend fun getListData(): List<Music> {
        return emptyList()
    }
}
