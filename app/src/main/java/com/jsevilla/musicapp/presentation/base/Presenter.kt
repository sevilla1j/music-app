package com.jsevilla.musicapp.presentation.base

interface Presenter<T : View?> {

    fun attachView(view: T)

    fun resume()

    fun pause()

    fun destroy()
}
