package com.jsevilla.musicapp.presentation.feature.splash

import android.graphics.PixelFormat
import android.os.Bundle
import android.view.Window
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseActivity
import com.jsevilla.musicapp.presentation.di.HasComponent
import com.jsevilla.musicapp.presentation.feature.splash.di.DaggerSplashComponent
import com.jsevilla.musicapp.presentation.feature.splash.di.SplashComponent

class SplashActivity : BaseActivity(), HasComponent<SplashComponent>,
    SplashFragment.SplashFragmentListener {

    private var component: SplashComponent? = null

    private lateinit var splashFragment: SplashFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        init(savedInstanceState)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val window = window
        window.setFormat(PixelFormat.RGBA_8888)
    }

    override fun onBackPressed() {
        // EMPTY
    }

    override fun getComponent(): SplashComponent? {
        return component
    }

    override fun onHome() {
        this.finish()
    }

    override fun init(savedInstanceState: Bundle?) {
        initializeInjector()
        if (savedInstanceState == null) {
            splashFragment = SplashFragment()
            addFragment(R.id.fltContainer, splashFragment)
        }
    }

    override fun initializeInjector() {
        this.component = DaggerSplashComponent.builder()
            .appComponent(appComponent)
            .activityModule(activityModule)
            .build()
    }

    override fun initControls() {
        //
    }

    override fun initEvents() {
        //
    }
}
