package com.jsevilla.musicapp.presentation.feature.home

import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.presentation.base.View

interface HomeView : View {
    fun showLoading()

    fun hideLoading()

    fun success(list: List<Music>)

    fun empty()
}
