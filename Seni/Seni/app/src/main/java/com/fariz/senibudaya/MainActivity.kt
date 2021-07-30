package com.fariz.senibudaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fariz.seni.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent  = Intent(this, HalamanKonten::class.java)

        btnSeniBudaya.setOnClickListener {
            intent.putExtra("type","seniBudaya")
            startActivity(intent)
        }

        btnMusik.setOnClickListener {
            val intent  = Intent(this, MenuMusik::class.java)
            startActivity(intent)
        }

        btnBatik.setOnClickListener {
            val intent  = Intent(this, MenuBatik::class.java)
            startActivity(intent)
        }

        btnDaftarPustaka.setOnClickListener {
            intent.putExtra("type","daftarPustaka")
            startActivity(intent)
        }

        btnTari.setOnClickListener {
            val intent  = Intent(this, MenuTari::class.java)
            startActivity(intent)
        }

        btnGamelan.setOnClickListener {
            val intent  = Intent(this, MenuGamelan::class.java)
            startActivity(intent)
        }
    }
}