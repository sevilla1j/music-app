package com.jsevilla.musicapp.presentation.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.jsevilla.musicapp.presentation.common.view.LoadingView
import com.jsevilla.musicapp.presentation.di.HasComponent

abstract class BaseFragment : Fragment(), LoadingView, View {

    private var mIsInjected = false
    private var loadingView: LoadingView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LoadingView) {
            this.loadingView = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        mIsInjected = try {
            onInjectView()
        } catch (e: IllegalStateException) {
            false
        }
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mIsInjected) onViewInjected(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!mIsInjected) {
            mIsInjected = onInjectView()
            if (mIsInjected) onViewInjected(savedInstanceState)
        }
    }

    @Throws(IllegalStateException::class)
    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((activity as HasComponent<*>).component)
            ?: throw IllegalStateException(componentType.simpleName + " has not been initialized yet.")
    }

    @Throws(IllegalStateException::class)
    protected open fun onInjectView(): Boolean {
        return false
    }

    @CallSuper
    protected open fun onViewInjected(savedInstanceState: Bundle?) {
    }

    override fun showLoading() {
        loadingView?.showLoading()
    }

    override fun hideLoading() {
        loadingView?.hideLoading()
    }
}
