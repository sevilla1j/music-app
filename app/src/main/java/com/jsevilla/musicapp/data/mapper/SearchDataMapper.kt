package com.jsevilla.musicapp.data.mapper

import com.jsevilla.musicapp.data.entity.MusicResponse
import com.jsevilla.musicapp.domain.entity.Music
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchDataMapper
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
                artistId = artistId,
                artistName = artistName,
                artistViewUrl = artistViewUrl,
                artworkUrl100 = artworkUrl100,
                artworkUrl30 = artworkUrl30,
                artworkUrl60 = artworkUrl60,
                collectionCensoredName = collectionCensoredName,
                collectionExplicitness = collectionExplicitness,
                collectionHdPrice = collectionHdPrice,
                collectionId = collectionId,
                collectionName = collectionName,
                collectionPrice = collectionPrice,
                collectionViewUrl = collectionViewUrl,
                contentAdvisoryRating = contentAdvisoryRating,
                country = country,
                currency = currency,
                discCount = discCount,
                discNumber = discNumber,
                isStreamable = isStreamable,
                kind = kind,
                longDescription = longDescription,
                previewUrl = previewUrl,
                primaryGenreName = primaryGenreName,
                releaseDate = releaseDate,
                shortDescription = shortDescription,
                trackCensoredName = trackCensoredName,
                trackCount = trackCount,
                trackExplicitness = trackExplicitness,
                trackHdPrice = trackHdPrice,
                trackId = trackId,
                trackName = trackName,
                trackNumber = trackNumber,
                trackPrice = trackPrice,
                trackTimeMillis = trackTimeMillis,
                trackViewUrl = trackViewUrl,
                wrapperType = wrapperType
            )
        }
        return mMusic
    }
}