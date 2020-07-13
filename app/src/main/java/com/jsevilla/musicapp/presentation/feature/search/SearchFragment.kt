package com.jsevilla.musicapp.presentation.feature.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.domain.entity.Music
import com.jsevilla.musicapp.presentation.base.BaseFragment
import com.jsevilla.musicapp.presentation.common.adapter.MusicAdapter
import com.jsevilla.musicapp.presentation.feature.search.di.SearchComponent
import javax.inject.Inject

class SearchFragment : BaseFragment(), SearchView {

    @Inject
    internal lateinit var presenter: SearchPresenter
    private var searchFragmentListener: SearchFragmentListener? = null

    private var btnBack: ImageView? = null
    private var textInputLayoutMusic: TextInputLayout? = null
    private var txtSearchMusic: TextInputEditText? = null

    private var recyclerViewItem: RecyclerView? = null
    private lateinit var musicAdapter: MusicAdapter
    private var progressEmpty: LottieAnimationView? = null
    private var progressEmptyConnection: LottieAnimationView? = null

    override fun context(): Context? {
        val activity = activity
        return activity?.applicationContext
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchFragmentListener) {
            searchFragmentListener = context
        }
    }

    override fun onViewInjected(savedInstanceState: Bundle?) {
        super.onViewInjected(savedInstanceState)
        this.presenter.attachView(this)
    }

    override fun onInjectView(): Boolean {
        getComponent(SearchComponent::class.java).inject(this)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        init(view)
        return view
    }

    override fun onDetach() {
        super.onDetach()
        searchFragmentListener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun init(view: View?) {
        btnBack = view?.findViewById(R.id.btnBack)
        textInputLayoutMusic = view?.findViewById(R.id.textInputLayoutMusic)
        txtSearchMusic = view?.findViewById(R.id.txtSearchMusic)
        recyclerViewItem = view?.findViewById(R.id.recyclerViewItem)
        progressEmpty = view?.findViewById(R.id.progress_empty)
        progressEmptyConnection = view?.findViewById(R.id.progress_empty_connection)

        recyclerViewItem?.visibility = View.GONE
        progressEmpty?.visibility = View.VISIBLE
        progressEmptyConnection?.visibility = View.GONE

        btnBack?.setOnClickListener {
            searchFragmentListener?.onBackPressed()
        }

        textInputLayoutMusic?.setEndIconOnClickListener {
            txtSearchMusic?.setText("")
        }

        txtSearchMusic?.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val text = txtSearchMusic?.text.toString()
                presenter.getSearch(text)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        progressEmpty?.playAnimation()
    }

    override fun showLoading() {
        searchFragmentListener?.showLoading()
    }

    override fun hideLoading() {
        searchFragmentListener?.hideLoading()
    }

    override fun success(list: List<Music>) {
        recyclerViewItem?.visibility = View.VISIBLE
        progressEmpty?.visibility = View.GONE
        progressEmptyConnection?.visibility = View.GONE

        recyclerViewItem?.layoutManager = LinearLayoutManager(activity)
        recyclerViewItem?.setHasFixedSize(true)
        recyclerViewItem?.apply {
            musicAdapter = MusicAdapter(
                list
            ) { musicItem: Music -> musicItemClicked(musicItem) }
            adapter = musicAdapter
            (adapter as MusicAdapter).notifyDataSetChanged()
        }
    }

    private fun musicItemClicked(item: Music) {
        Log.e("API", "FUNCIONO")
    }

    override fun empty() {
        recyclerViewItem?.visibility = View.GONE
        progressEmpty?.visibility = View.VISIBLE
        progressEmptyConnection?.visibility = View.GONE
        progressEmpty?.playAnimation()
    }

    override fun connection() {
        recyclerViewItem?.visibility = View.GONE
        progressEmpty?.visibility = View.VISIBLE
        progressEmptyConnection?.visibility = View.GONE
        progressEmptyConnection?.playAnimation()
    }

    internal interface SearchFragmentListener {
        fun showLoading()

        fun hideLoading()

        fun onBackPressed()
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
