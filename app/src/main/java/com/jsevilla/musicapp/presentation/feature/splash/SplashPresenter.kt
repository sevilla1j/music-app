package com.jsevilla.musicapp.presentation.feature.splash

import android.os.Handler
import com.jsevilla.musicapp.presentation.base.Presenter
import com.jsevilla.musicapp.presentation.di.PerActivity
import kotlinx.coroutines.*
import java.lang.Runnable
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@PerActivity
class SplashPresenter
@Inject internal constructor() : Presenter<SplashView>, CoroutineScope {

    private var splashView: SplashView? = null
    private var job = SupervisorJob()
    private val updateHandler = Handler()

    private val runnable = Runnable {
        splashView?.initData()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attachView(view: SplashView) {
        splashView = view
    }

    override fun resume() {
        //
    }

    override fun pause() {
        //
    }

    override fun destroy() {
        this.coroutineContext.cancelChildren()
    }

    fun data() {
        launch(Dispatchers.IO) {
            try {
                updateHandler.postDelayed(runnable, 3000)
            } catch (e: Exception) {
            }
        }
    }
}
