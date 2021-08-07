package com.eva.dikejar.ui.video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eva.dikejar.R
import com.eva.dikejar.databinding.ItemListVideoBinding

class ListVideoRecyclerViewAdapter :
    RecyclerView.Adapter<ListVideoRecyclerViewAdapter.ListVideoViewHolder>() {

    lateinit var videoInterface: VideoInterface

    val videoList = mutableListOf<VideoModel>()

    fun setData(newData: MutableList<VideoModel>) {
        this.videoList.addAll(newData)
    }

    fun setInterface(inter: VideoInterface) {
        videoInterface = inter
    }

    inner class ListVideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemListVideoBinding.bind(view)
        fun bind(model: VideoModel) {
            binding.tvTitle.text=model.title
            binding.root.setOnClickListener {
                videoInterface.onclick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVideoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_video, parent, false)
        return ListVideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListVideoViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    interface VideoInterface {
        fun onclick(model: VideoModel)
    }

}