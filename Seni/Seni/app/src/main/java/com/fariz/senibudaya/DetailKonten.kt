package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fariz.seni.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_tari.*

class DetailKonten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tari)

        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val photo = intent.getIntExtra("img", R.drawable.tari_11)


        Picasso.get()
            .load(photo)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(imgDetTari)

        descDetTari.text = desc
        titleDetTari.text = name


    }
}