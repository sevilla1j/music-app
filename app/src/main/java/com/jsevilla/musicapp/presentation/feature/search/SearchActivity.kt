package com.jsevilla.musicapp.presentation.feature.search

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.View
import android.view.Window
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseActivity
import com.jsevilla.musicapp.presentation.di.HasComponent
import com.jsevilla.musicapp.presentation.feature.search.di.DaggerSearchComponent
import com.jsevilla.musicapp.presentation.feature.search.di.SearchComponent
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), HasComponent<SearchComponent>,
    SearchFragment.SearchFragmentListener {

    private var component: SearchComponent? = null

    private val searchFragment = SearchFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_search)

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
                searchFragment,
                true,
                getString(R.string.txt_search)
            )
        }
    }

    override fun initializeInjector() {
        this.component = DaggerSearchComponent.builder()
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

    override fun getComponent(): SearchComponent? {
        return component
    }

    override fun onBackPressed() {
        this.navigator.navigateToHome(this)
    }

    override fun showLoading() {
        view_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        view_loading.visibility = View.GONE
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }
}
