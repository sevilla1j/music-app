package com.jsevilla.musicapp.presentation.feature.search

import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.presentation.base.View

interface SearchView : View {
    fun showLoading()

    fun hideLoading()

    fun success(list: List<Music>)

    fun empty()

    fun connection()
}