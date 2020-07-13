package com.jsevilla.musicapp.data.net.service

import com.jsevilla.musicapp.data.entity.ApiEntity
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ISearchService {
    @Headers("Content-Type: application/json")
    @GET(value = "search")
    suspend fun getSearch(
        @Query("term") search: String?,
        @Query("mediaType") mediaType: String?,
        @Query("limit") limit: Int?
    ): ApiEntity
}
