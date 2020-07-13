package com.jsevilla.musicapp.data.net.service.impl

import android.content.Context
import com.jsevilla.musicapp.BuildConfig
import com.jsevilla.musicapp.data.entity.ApiEntity
import com.jsevilla.musicapp.data.net.RestApi
import com.jsevilla.musicapp.data.net.service.IHomeService
import pe.iqproject.library.net.exception.NetworkConnectionException

class HomeService(
    context: Context
) : BaseService(context), IHomeService {

    private val service: IHomeService =
        RestApi.create(
            IHomeService::class.java,
            BuildConfig.BASE_URL
        )

    override suspend fun getListData(): ApiEntity {
        if (isThereInternetConnection) {
            return service.getListData()
        } else {
            throw NetworkConnectionException()
        }
    }
}
