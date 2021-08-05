package com.eva.dikejar.pdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eva.dikejar.R
import com.eva.dikejar.databinding.ActivityViewPDFBinding

class ViewPDFActivity : AppCompatActivity() {

    val binding by lazy {ActivityViewPDFBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar?.hide()
        supportActionBar?.hide()


        val assetName = intent.getStringExtra("file")

        binding.pdfView.fromAsset(assetName)
            .spacing(0)
            .enableSwipe(true) // allows to block changing pages using swipe
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .load()


    }
}