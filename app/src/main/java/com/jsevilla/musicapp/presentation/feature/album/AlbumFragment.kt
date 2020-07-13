package com.jsevilla.musicapp.presentation.feature.album

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.base.BaseFragment
import com.jsevilla.musicapp.presentation.feature.album.di.AlbumComponent
import javax.inject.Inject

class AlbumFragment : BaseFragment(), AlbumView {

    @Inject
    internal lateinit var presenter: AlbumPresenter
    private var albumFragmentListener: AlbumFragmentListener? = null

    private var btnBack: ImageView? = null
    private var imgPhoto: ImageView? = null
    private var txtAlbum: TextView? = null
    private var txtArtist: TextView? = null
    private var recyclerViewItem: RecyclerView? = null

    override fun context(): Context? {
        val activity = activity
        return activity?.applicationContext
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AlbumFragmentListener) {
            albumFragmentListener = context
        }
    }

    override fun onViewInjected(savedInstanceState: Bundle?) {
        super.onViewInjected(savedInstanceState)
        this.presenter.attachView(this)
    }

    override fun onInjectView(): Boolean {
        getComponent(AlbumComponent::class.java).inject(this)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album, container, false)
        init(view)
        return view
    }

    override fun onDetach() {
        super.onDetach()
        albumFragmentListener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun init(view: View?) {
        btnBack = view?.findViewById(R.id.btnBack)
        imgPhoto = view?.findViewById(R.id.imgPhoto)
        txtAlbum = view?.findViewById(R.id.txtAlbum)
        txtArtist = view?.findViewById(R.id.txtArtist)
        recyclerViewItem = view?.findViewById(R.id.recyclerViewItem)

        btnBack?.setOnClickListener {
            albumFragmentListener?.onBackPressed()
        }
    }

    internal interface AlbumFragmentListener {
        fun showLoading()

        fun hideLoading()

        fun onBackPressed()
    }

    companion object {
        fun newInstance() = AlbumFragment()
    }
}
