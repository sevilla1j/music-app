package com.jsevilla.musicapp.presentation.feature.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.presentation.base.BaseFragment
import com.jsevilla.musicapp.presentation.feature.home.di.HomeComponent
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeView {

    @Inject
    internal lateinit var presenter: HomePresenter
    private var homeFragmentListener: HomeFragmentListener? = null

    private var btnSetting: ImageView? = null
    private var btnMenu: ImageView? = null
    private var btnSearch: LinearLayout? = null
    private var empty: LottieAnimationView? = null

    private var mRecyclerView: RecyclerView? = null

    override fun context(): Context? {
        val activity = activity
        return activity?.applicationContext
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeFragmentListener) {
            homeFragmentListener = context
        }
    }

    override fun onViewInjected(savedInstanceState: Bundle?) {
        super.onViewInjected(savedInstanceState)
        this.presenter.attachView(this)
        getData()
    }

    override fun onInjectView(): Boolean {
        getComponent(HomeComponent::class.java).inject(this)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        presenter.getListData()
    }

    override fun onDetach() {
        super.onDetach()
        homeFragmentListener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun init(view: View?) {
        btnSetting = view?.findViewById(R.id.btnSetting)
        btnMenu = view?.findViewById(R.id.btnMenu)
        btnSearch = view?.findViewById(R.id.btnSearch)

        btnSetting?.setOnClickListener {
            homeFragmentListener?.openSetting()
        }

        btnMenu?.setOnClickListener {
            homeFragmentListener?.openMenu()
        }

        btnSearch?.setOnClickListener {
            homeFragmentListener?.openSearch()
        }

        mRecyclerView = view?.findViewById(R.id.recyclerViewItem)

        empty = view?.findViewById(R.id.progress_empty)
        empty?.playAnimation()
    }

    private fun getData() {
        this.presenter.getListData()
    }

    override fun showLoading() {
        homeFragmentListener?.showLoading()
    }

    override fun hideLoading() {
        homeFragmentListener?.hideLoading()
    }

    override fun success(list: List<Music>) {
        mRecyclerView?.visibility = View.VISIBLE
        empty?.visibility = View.GONE
    }

    override fun empty() {
        mRecyclerView?.visibility = View.GONE
        empty?.visibility = View.VISIBLE
        empty?.playAnimation()
    }

    internal interface HomeFragmentListener {
        fun showLoading()

        fun hideLoading()

        fun openMenu()

        fun openSetting()

        fun openSearch()
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
