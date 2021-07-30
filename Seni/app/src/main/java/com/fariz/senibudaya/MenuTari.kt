package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fariz.seni.R
import com.fariz.senibudaya.Data.Tari
import com.fariz.senibudaya.Data.tariDatas
import com.fariz.senibudaya.ModelAdapter.AdapterTari
import kotlinx.android.synthetic.main.activity_list_tari.*

class MenuTari : AppCompatActivity() {

    private var list: ArrayList<Tari> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tari)
        rvTari.setHasFixedSize(true)
        list.addAll(tariDatas.listTari)

        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvTari.layoutManager = LinearLayoutManager(this)
        val listTariAdapterTari =
            AdapterTari(list, this)
        rvTari.adapter = listTariAdapterTari
    }

}