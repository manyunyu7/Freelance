package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fariz.seni.R
import com.fariz.senibudaya.Data.Musik
import com.fariz.senibudaya.Data.musikDatas
import com.fariz.senibudaya.ModelAdapter.AdapterMusik
import kotlinx.android.synthetic.main.activity_menu_musik.*

class MenuMusik : AppCompatActivity() {
    private var list: ArrayList<Musik> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_musik)
        list.addAll(musikDatas.listMusik)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMusik.layoutManager = LinearLayoutManager(this)
        val adapterMusik =
            AdapterMusik(list, this)
        rvMusik.adapter = adapterMusik
    }
}