package com.fariz.angklung

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fariz.angklung.databinding.ItemAngklungBinding

class AngklungAdapter : RecyclerView.Adapter<AngklungAdapter.AngklungViewHolder>() {


    private val angklungList = mutableListOf<ModelAngklung>()

    private lateinit var angklungInterface: AngklungInterface

    fun setInterface(inter: AngklungInterface) {
        this.angklungInterface = inter
    }

    fun setData(newData: MutableList<ModelAngklung>) {
        angklungList.addAll(newData)
    }

    inner class AngklungViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemAngklungBinding.bind(view)
        fun onBind(model: ModelAngklung) {
            binding.root.setOnClickListener {
                angklungInterface.onclick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AngklungViewHolder {
        val view = ItemAngklungBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AngklungViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: AngklungViewHolder, position: Int) {
        holder.onBind(angklungList[position])
    }

    override fun getItemCount(): Int {
        return angklungList.size
    }


    interface AngklungInterface {
        fun onclick(model: ModelAngklung)
    }


}