package com.jsevilla.musicapp.presentation.feature.album

import com.jsevilla.musicapp.presentation.base.View

interface AlbumView : View {
    fun showLoading()

    fun hideLoading()
}
