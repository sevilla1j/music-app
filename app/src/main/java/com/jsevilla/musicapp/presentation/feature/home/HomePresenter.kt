package com.jsevilla.musicapp.presentation.feature.home

import com.jsevilla.musicapp.domain.interactor.HomeUseCase
import com.jsevilla.musicapp.presentation.base.Presenter
import com.jsevilla.musicapp.presentation.di.PerActivity
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@PerActivity
class HomePresenter
@Inject
internal constructor(
    private val homeUseCase: HomeUseCase
) : Presenter<HomeView>, CoroutineScope {

    private var homeView: HomeView? = null
    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attachView(view: HomeView) {
        homeView = view
    }

    override fun resume() {
        //
    }

    override fun pause() {
        //
    }

    override fun destroy() {
        this.homeView = null
        this.coroutineContext.cancelChildren()
    }

    fun getListData() {
        homeView?.showLoading()
        launch(Dispatchers.IO) {
            try {
                val listOrder = homeUseCase.getListData()
                listOrder.let {
                    launch(Dispatchers.Main) {
                        homeView?.hideLoading()

                        if (it.isNotEmpty())
                            homeView?.success(it)
                        else
                            homeView?.empty()
                    }
                }
            } catch (e: Exception) {
                println("Error $e")
                homeView?.hideLoading()
            }
        }
    }
}
