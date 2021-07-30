package com.fariz.angklung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fariz.angklung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            startActivity(Intent(this@MainActivity,AngklungActivity::class.java))
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this@MainActivity,HistoryActivity::class.java))
        }

    }
}