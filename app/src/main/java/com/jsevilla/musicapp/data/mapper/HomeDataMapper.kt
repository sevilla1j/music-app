package com.jsevilla.musicapp.data.mapper

import com.jsevilla.musicapp.data.entity.MusicResponse
import com.jsevilla.musicapp.domain.entity.Music
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDataMapper
@Inject
internal constructor() {
    fun transformList(list: List<MusicResponse?>?): List<Music> {
        return mutableListOf<Music>().apply {
            list?.forEach {
                it?.let { it1 -> transform(it1) }?.let { it2 -> add(it2) }
            }
        }.toList()
    }

    private fun transform(musicResponse: MusicResponse?): Music {
        var mMusic = Music()
        musicResponse?.run {
            mMusic = Music(

            )
        }
        return mMusic
    }
}
