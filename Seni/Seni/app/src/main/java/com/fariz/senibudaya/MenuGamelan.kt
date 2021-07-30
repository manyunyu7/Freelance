package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fariz.seni.R
import com.fariz.senibudaya.Data.Gamelan
import com.fariz.senibudaya.Data.gamelanDatas
import com.fariz.senibudaya.ModelAdapter.AdapterGamelan
import kotlinx.android.synthetic.main.activity_menu_gamelan.*

class MenuGamelan : AppCompatActivity() {

    private var list: ArrayList<Gamelan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_gamelan)
        rvGamelan.setHasFixedSize(true)
        list.addAll(gamelanDatas.listGamelan)

        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvGamelan.layoutManager = LinearLayoutManager(this)
        val adapterGamelan =
            AdapterGamelan(list, this)
        rvGamelan.adapter = adapterGamelan
    }

}