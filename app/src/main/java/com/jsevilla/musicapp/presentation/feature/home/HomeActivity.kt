package com.jsevilla.musicapp.presentation.feature.home

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.View
import android.view.Window
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseActivity
import com.jsevilla.musicapp.presentation.di.HasComponent
import com.jsevilla.musicapp.presentation.feature.home.di.DaggerHomeComponent
import com.jsevilla.musicapp.presentation.feature.home.di.HomeComponent
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), HasComponent<HomeComponent>,
    HomeFragment.HomeFragmentListener {

    private var component: HomeComponent? = null

    private val homeFragment = HomeFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_home)

        init(savedInstanceState)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val window = window
        window.setFormat(PixelFormat.RGBA_8888)
    }

    override fun init(savedInstanceState: Bundle?) {
        initializeInjector()

        if (savedInstanceState == null) {
            addFragment(
                R.id.fltContainer,
                homeFragment,
                true,
                getString(R.string.txt_home)
            )
        }
    }

    override fun initializeInjector() {
        this.component = DaggerHomeComponent.builder()
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

    override fun getComponent(): HomeComponent? {
        return component
    }

    override fun showLoading() {
        view_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        view_loading.visibility = View.GONE
    }

    override fun openMenu() {

    }

    override fun openSetting() {
        this.navigator.navigateToSetting()
    }

    override fun openSearch() {
        this.navigator.navigateToSearch()
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
