package com.fariz.senibudaya.ModelAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fariz.senibudaya.Data.Gamelan
import com.fariz.senibudaya.DetailKonten
import com.fariz.seni.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_tari.view.*

class AdapterGamelan(
    private val gamelan: ArrayList<Gamelan>,
    val context: Context?
) : RecyclerView.Adapter<HolderGamelan>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGamelan {
        val view: View =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_tari, parent, false)
        return HolderGamelan(view)
    }

    override fun getItemCount(): Int {
        return gamelan.size
    }

    override fun onBindViewHolder(holder: HolderGamelan, position: Int) {
        val tariName = gamelan[position].name
        val tariDetail = gamelan[position].detail
        val tariPhoto = gamelan[position].images

        Picasso.get()
            .load(tariPhoto)
            .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
            .into(holder.phTariPhoto)
//
        holder.phTariName.text = tariName
        holder.phTariDetail.text = tariDetail

        holder.itemView.setOnClickListener {
            makeToast(tariName)
            val a = Intent(context, DetailKonten::class.java)
            a.putExtra("name",tariName)
            a.putExtra("desc",tariDetail)
            a.putExtra("img",tariPhoto)
            context?.startActivity(a)
        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
}


public class HolderGamelan(view: View) : RecyclerView.ViewHolder(view) {
    val phTariPhoto = view.ivTariPict
    val phTariName = view.tvTariName
    val phTariDetail = view.desc_tari
}