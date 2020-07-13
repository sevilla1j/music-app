package com.jsevilla.musicapp.data.net.service

import com.jsevilla.musicapp.data.entity.ApiEntity
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IHomeService {
    @FormUrlEncoded
    @POST(value = "")
    suspend fun getListData(): ApiEntity
}
