package com.jsevilla.musicapp.presentation.feature.album

import com.jsevilla.musicapp.domain.interactor.AlbumUseCase
import com.jsevilla.musicapp.presentation.base.Presenter
import com.jsevilla.musicapp.presentation.di.PerActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@PerActivity
class AlbumPresenter
@Inject
internal constructor(
    private val albumUseCase: AlbumUseCase
) : Presenter<AlbumView>, CoroutineScope {

    private var albumView: AlbumView? = null
    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attachView(view: AlbumView) {
        albumView = view
    }

    override fun resume() {
        //
    }

    override fun pause() {
        //
    }

    override fun destroy() {
        this.albumView = null
        this.coroutineContext.cancelChildren()
    }
}
