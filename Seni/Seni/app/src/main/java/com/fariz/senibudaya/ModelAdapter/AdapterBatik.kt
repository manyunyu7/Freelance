package com.fariz.senibudaya.ModelAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fariz.senibudaya.Data.Batik
import com.fariz.senibudaya.DetailKonten
import com.fariz.seni.R
import com.fariz.senibudaya.HalamanKonten
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_tari.view.*

class AdapterBatik(
    private val tari: ArrayList<Batik>,
    val context: Context?
) : RecyclerView.Adapter<HolderBatik>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderBatik {
        val view: View =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_tari, parent, false)
        return HolderBatik(view)
    }

    override fun getItemCount(): Int {
        return tari.size
    }

    override fun onBindViewHolder(holder: HolderBatik, position: Int) {
        val tariName = tari[position].name
        val tariDetail = tari[position].detail
        val tariPhoto = tari[position].images

        Picasso.get()
            .load(tariPhoto)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(holder.phTariPhoto)
//
        holder.phTariName.text = tariName
        holder.phTariDetail.text = tariDetail

        holder.itemView.setOnClickListener {
            val c = Intent(context, HalamanKonten::class.java)

            when (tari[position].name) {
                "Jawa Barat" -> {
                    c.putExtra("type", "jabar")
                    context?.startActivity(c)
                }
                "Jawa Tengah" -> {
                    c.putExtra("type", "jateng")
                    context?.startActivity(c)
                }
                "Jawa Timur" -> {
                    c.putExtra("type", "jatim")
                    context?.startActivity(c)
                }
                else -> {
                    val a = Intent(context, DetailKonten::class.java)
                    a.putExtra("name", tariName)
                    a.putExtra("desc", tariDetail)
                    a.putExtra("img", tariPhoto)
                    context?.startActivity(a)
                }
            }


            makeToast(tariName)

        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}


public class HolderBatik(view: View) : RecyclerView.ViewHolder(view) {
    val phTariPhoto = view.ivTariPict
    val phTariName = view.tvTariName
    val phTariDetail = view.desc_tari
}