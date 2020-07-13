package com.jsevilla.musicapp.presentation.feature.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jsevilla.musicapp.R

class AlbumFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album, container, false)
        init(view)
        return view
    }

    private fun init(view: View?) {

    }

    companion object {
        fun newInstance() = AlbumFragment()
    }
}
