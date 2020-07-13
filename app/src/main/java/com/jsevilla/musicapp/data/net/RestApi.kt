package com.jsevilla.musicapp.data.net

import com.jsevilla.musicapp.BuildConfig
import com.jsevilla.musicapp.data.common.network.ApiService

object RestApi {
    private const val CONNECT_TIMEOUT: Long = 30
    private const val READ_TIMEOUT: Long = 30
    private const val WRITE_TIMEOUT: Long = 30

    private val api = ApiService.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .connectTimeout(CONNECT_TIMEOUT)
        .readTimeout(READ_TIMEOUT)
        .writeTimeout(WRITE_TIMEOUT)
        .build()

    fun <S> create(clazz: Class<S>): S {
        return api.create(clazz)
    }

    fun <S> create(clazz: Class<S>, url: String?): S {
        return api.create(clazz, url)
    }
}
