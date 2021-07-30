package com.fariz.angklung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fariz.angklung.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    val binding by lazy {ActivityHistoryBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar?.hide()
        supportActionBar?.hide()

        binding.btnBackFromDetail.setOnClickListener {
            finish()
            super.onBackPressed()
        }

        val assetName = "neo_angklung.pdf"

        binding.pdfView.fromAsset(assetName)
            .spacing(0)
            .enableSwipe(true) // allows to block changing pages using swipe
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .load()
    }
}