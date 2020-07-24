package com.jsevilla.musicapp.presentation.feature.album

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.View
import android.view.Window
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseActivity
import com.jsevilla.musicapp.presentation.di.HasComponent
import com.jsevilla.musicapp.presentation.feature.album.di.AlbumComponent
import com.jsevilla.musicapp.presentation.feature.album.di.DaggerAlbumComponent
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : BaseActivity(), HasComponent<AlbumComponent>,
    AlbumFragment.AlbumFragmentListener {

    private var component: AlbumComponent? = null

    private val albumFragment = AlbumFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_album)

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
                albumFragment,
                true,
                getString(R.string.txt_album)
            )
        }
    }

    override fun initializeInjector() {
        this.component = DaggerAlbumComponent.builder()
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

    override fun getComponent(): AlbumComponent? {
        return component
    }

    override fun onBackPressed() {
        this.navigator.navigateToSearch(this)
    }

    override fun showLoading() {
        view_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        view_loading.visibility = View.GONE
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, AlbumActivity::class.java)
        }
    }
}
