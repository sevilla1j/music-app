package com.jsevilla.musicapp.data.net.service.impl

import android.content.Context
import com.jsevilla.musicapp.BuildConfig
import com.jsevilla.musicapp.data.common.exception.NetworkConnectionException
import com.jsevilla.musicapp.data.entity.ApiEntity
import com.jsevilla.musicapp.data.net.RestApi
import com.jsevilla.musicapp.data.net.service.ISearchService

class SearchService(
    context: Context
) : BaseService(context), ISearchService {

    private val service: ISearchService =
        RestApi.create(
            ISearchService::class.java,
            BuildConfig.BASE_URL
        )

    override suspend fun getSearch(search: String?, mediaType: String?, limit: Int?): ApiEntity {
        if (isThereInternetConnection) {
            return service.getSearch(search, mediaType, limit)
        } else {
            throw NetworkConnectionException()
        }
    }
}
