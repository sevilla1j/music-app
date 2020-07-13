package com.jsevilla.musicapp.presentation.common.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.domain.entity.Music
import kotlinx.android.synthetic.main.layout_card_music.view.*


class MusicAdapter
constructor(
    private val listMusic: List<Music>,
    private val clickListener: (Music) -> Unit
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_card_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        (holder).bind(listMusic[position], clickListener)
    }

    override fun getItemCount(): Int = listMusic.size

    class MusicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(
            music: Music,
            clickListener: (Music) -> Unit
        ) {

            if (music.collectionName.isNullOrEmpty()) {
                itemView.txtName.text = music.artistName
                itemView.txtArtist.text = music.trackName
                itemView.txtAlbum.visibility = View.GONE
            } else {
                itemView.txtName.text = music.collectionName
                itemView.txtArtist.text = music.artistName
                itemView.txtAlbum.visibility = View.VISIBLE
                itemView.txtAlbum.text = music.trackName
            }

            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

            Glide
                .with(itemView.cardLayout)
                .load(music.artworkUrl100)
                .apply(requestOptions)
                .placeholder(R.drawable.logotipo)
                .into(itemView.imgPhoto)

            itemView.setOnClickListener { clickListener(music) }
        }
    }
}
