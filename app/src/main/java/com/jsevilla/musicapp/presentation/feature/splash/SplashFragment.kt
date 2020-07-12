package com.jsevilla.musicapp.presentation.feature.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseFragment
import com.jsevilla.musicapp.presentation.feature.splash.di.SplashComponent
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

class SplashFragment : BaseFragment(), SplashView {

    @Inject
    internal lateinit var presenter: SplashPresenter

    private var listener: SplashFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SplashFragmentListener) {
            this.listener = context
        }
    }

    override fun onViewInjected(savedInstanceState: Bundle?) {
        super.onViewInjected(savedInstanceState)
        this.presenter.attachView(this)
        this.presenter.data()
    }

    override fun onInjectView(): Boolean {
        getComponent(SplashComponent::class.java).inject(this)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun initData() {
        listener?.onHome()
    }

    override fun context(): Context? {
        val activity = activity
        return activity?.applicationContext
    }

    override fun onResume() {
        super.onResume()
        progress_circular.playAnimation()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    internal interface SplashFragmentListener {
        fun onHome()
    }
}
