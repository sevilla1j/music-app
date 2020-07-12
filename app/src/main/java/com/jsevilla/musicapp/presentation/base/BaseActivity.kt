package com.jsevilla.musicapp.presentation.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jsevilla.musicapp.App
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.di.component.AppComponent
import com.jsevilla.musicapp.presentation.di.module.ActivityModule
import com.jsevilla.musicapp.presentation.feature.splash.di.SplashComponent
import com.jsevilla.musicapp.presentation.navigation.Navigator
import com.jsevilla.musicapp.presentation.util.StringUtil
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    protected val appComponent: AppComponent
        get() = (application as App).appComponent!!

    protected val activityModule: ActivityModule
        get() = ActivityModule(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.appComponent.inject(this)
    }

    protected abstract fun init(savedInstanceState: Bundle?)

    protected abstract fun initializeInjector()

    protected abstract fun initControls()

    protected abstract fun initEvents()

    fun context(): Context {
        return applicationContext
    }

    val visibleFragment: Fragment?
        get() {
            val fragmentManager = supportFragmentManager
            return fragmentManager.findFragmentById(R.id.fltContainer)
        }

    @JvmOverloads
    protected fun addFragment(
        containerViewId: Int,
        fragment: Fragment?,
        isFirst: Boolean = true,
        name: String = ""
    ) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (StringUtil.isNullOrEmpty(name))
            fragment?.let { fragmentTransaction.add(containerViewId, it) }
        else
            fragment?.let { fragmentTransaction.add(containerViewId, it, name) }
        if (!isFirst)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    @JvmOverloads
    protected fun replaceFragment(
        containerViewId: Int,
        fragment: Fragment?,
        isFirst: Boolean,
        name: String = "",
        transition: Boolean = true
    ) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        if (transition) fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (StringUtil.isNullOrEmpty(name)) {
            fragment?.let { fragmentTransaction.replace(containerViewId, it) }
        } else {
            fragment?.let { fragmentTransaction.replace(containerViewId, it, name) }
        }
        if (!isFirst)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
