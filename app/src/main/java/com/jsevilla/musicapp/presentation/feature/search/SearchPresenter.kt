package com.jsevilla.musicapp.presentation.feature.search

import com.jsevilla.musicapp.data.common.exception.NetworkConnectionException
import com.jsevilla.musicapp.domain.interactor.SearchUseCase
import com.jsevilla.musicapp.presentation.base.Presenter
import com.jsevilla.musicapp.presentation.di.PerActivity
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@PerActivity
class SearchPresenter
@Inject
internal constructor(
    private val searchUseCase: SearchUseCase
) : Presenter<SearchView>, CoroutineScope {

    private var searchView: SearchView? = null
    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attachView(view: SearchView) {
        searchView = view
    }

    override fun resume() {
        //
    }

    override fun pause() {
        //
    }

    override fun destroy() {
        this.searchView = null
        this.coroutineContext.cancelChildren()
    }

    fun getSearch(text: String) {
        searchView?.showLoading()
        launch(Dispatchers.IO) {
            try {
                val listMusic = searchUseCase.getSearch(text)
                listMusic.let {
                    launch(Dispatchers.Main) {
                        searchView?.hideLoading()

                        if (it.isNotEmpty())
                            searchView?.success(it)
                        else
                            searchView?.empty()
                    }
                }
            } catch (e: Exception) {
                println("Error $e")
                if (e is NetworkConnectionException) {
                    searchView?.connection()
                    searchView?.hideLoading()
                } else {
                    searchView?.hideLoading()
                }
            }
        }
    }
}