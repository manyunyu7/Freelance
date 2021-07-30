package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fariz.seni.R
import com.fariz.senibudaya.Data.Batik
import com.fariz.senibudaya.Data.batikDatas
import com.fariz.senibudaya.ModelAdapter.AdapterBatik
import kotlinx.android.synthetic.main.activity_menu_batik.*

class MenuBatik : AppCompatActivity() {
    private var list: ArrayList<Batik> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_batik)
        list.addAll(batikDatas.listBatik)

        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvBatik.layoutManager = LinearLayoutManager(this)
        val adapterBatik =
            AdapterBatik(list, this)
        rvBatik.adapter = adapterBatik
    }

}