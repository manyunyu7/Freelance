package com.fariz.senibudaya.ModelAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fariz.senibudaya.Data.Musik
import com.fariz.seni.R
import com.fariz.senibudaya.HalamanKonten
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_tari.view.*

class AdapterMusik(
    private val tari: ArrayList<Musik>,
    val context: Context?
) : RecyclerView.Adapter<HolderMusik>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMusik {
        val view: View =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_tari, parent, false)
        return HolderMusik(view)
    }

    override fun getItemCount(): Int {
        return tari.size
    }

    override fun onBindViewHolder(holder: HolderMusik, position: Int) {
        val tariName = tari[position].name
        val tariDetail = tari[position].detail
        val tariPhoto = tari[position].images

        holder.phTariPhoto.visibility = View.GONE
        holder.phTariDetail.visibility = View.GONE

        Picasso.get()
            .load(tariPhoto)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(holder.phTariPhoto)
//
        holder.phTariName.text = tariName
        holder.phTariDetail.text = tariDetail

        holder.itemView.setOnClickListener {
            val pdfFileCode: List<String> = tariName.split(".")

            val c = Intent(context, HalamanKonten::class.java)
            makeToast(pdfFileCode[1])
            c.putExtra("type", pdfFileCode[0])
            c.putExtra("title", tari[position].name)
            context?.startActivity(c)
        }


    }

    private fun makeToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}


public class HolderMusik(view: View) : RecyclerView.ViewHolder(view) {
    val phTariPhoto = view.ivTariPict
    val phTariName = view.tvTariName
    val phTariDetail = view.desc_tari
}