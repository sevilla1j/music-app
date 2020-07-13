package com.jsevilla.musicapp.data.entity

import com.google.gson.annotations.SerializedName

data class ApiEntity(
    @SerializedName("resultCount")
    var resultCount: Int? = null,

    @SerializedName("results")
    var results: List<MusicResponse>? = null
)