package com.fariz.senibudaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fariz.seni.R
import kotlinx.android.synthetic.main.activity_halaman_konten.*


class HalamanKonten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_konten)

        btnBackFromDetail.setOnClickListener {
            super.onBackPressed()
        }

        val content = intent.getStringExtra("type")
        var assetName = ""
        var title = ""
        when (content) {
            "seniBudaya" -> {
                assetName = "seni_budaya.pdf"
                title = "Seni Budaya"
            }
            "daftarPustaka" -> {
                assetName = "dapus.pdf"
                title = "Daftar Pustaka"
            }
            "jabar" -> {
                assetName = "batik_jabar.pdf"
                title = "Batik Khas Jawa Barat"
            }
            "jateng" -> {
                assetName = "batik_jateng.pdf"
                title = "Batik Khas Jawa Tengah"
            }
            "jatim" -> {
                assetName = "batik_jatim.pdf"
                title = "Batik Khas Jawa Timur"
            }
            "1" -> {
                assetName = "01 Aceh.pdf"
                title = intent.getStringExtra("title")
            }
            "2" -> {
                assetName = "02 Sumatera Utara.pdf"
                title = intent.getStringExtra("title")
            }
            "3" -> {
                assetName = "03 Sumatera Barat.pdf"
                title = intent.getStringExtra("title")
            }
            "4" -> {
                assetName = "04 Riau.pdf"
                title = intent.getStringExtra("title")
            }
            "5" -> {
                assetName = "05 Jambi.pdf"
                title = intent.getStringExtra("title")
            }
            "6" -> {
                assetName = "06 Sumatera Selatan.pdf"
                title = intent.getStringExtra("title")
            }
            "7" -> {
                assetName = "07 Bengkulu.pdf"
                title = intent.getStringExtra("title")
            }
            "8" -> {
                assetName = "08 Lampung.pdf"
                title = intent.getStringExtra("title")
            }
            "9" -> {
                assetName = "09 Kepulauan Bangka Belitung.pdf"
                title = intent.getStringExtra("title")
            }
            "10" -> {
                assetName = "10 Kepulauan Riau.pdf"
                title = intent.getStringExtra("title")
            }
            "11" -> {
                assetName = "11 Jakarta.pdf"
                title = intent.getStringExtra("title")
            }
            "12" -> {
                assetName = "12 Jawa Barat.pdf"
                title = intent.getStringExtra("title")
            }
            "13" -> {
                assetName = "13 Banten.pdf"
                title = intent.getStringExtra("title")
            }
            "14" -> {
                assetName = "14 Jawa Tengah.pdf"
                title = intent.getStringExtra("title")
            }
            "15" -> {
                assetName = "15 Yogyakarta.pdf"
                title = intent.getStringExtra("title")
            }
            "16" -> {
                assetName = "16 Jawa Timur.pdf"
                title = intent.getStringExtra("title")
            }
            "17" -> {
                assetName = "17 Bali.pdf"
                title = intent.getStringExtra("title")
            }
            "18" -> {
                assetName = "18 Nusa Tenggara Barat.pdf"
                title = intent.getStringExtra("title")
            }
            "19" -> {
                assetName = "19 Nusa tenggara Timur.pdf"
                title = intent.getStringExtra("title")
            }
            "20" -> {
                assetName = "20 Kalimantan Barat.pdf"
                title = intent.getStringExtra("title")
            }
            "21" -> {
                assetName = "21 Kalimantan Timur.pdf"
                title = intent.getStringExtra("title")
            }
            "22" -> {
                assetName = "22 Kalimantan Selatan.pdf"
                title = intent.getStringExtra("title")
            }
            "23" -> {
                assetName = "23 Kalimantan Tengah.pdf"
                title = intent.getStringExtra("title")
            }
            "24" -> {
                assetName = "24 Sulawesi Utara.pdf"
                title = intent.getStringExtra("title")
            }
            "25" -> {
                assetName = "25 Sulawesi Tengah.pdf"
                title = intent.getStringExtra("title")
            }
            "26" -> {
                assetName = "26 Sulawesi Tenggara.pdf"
                title = intent.getStringExtra("title")
            }
            "27" -> {
                assetName = "27 Sulawesi Selatan.pdf"
                title = intent.getStringExtra("title")
            }
            "28" -> {
                assetName = "28 Sulawesi Barat.pdf"
                title = intent.getStringExtra("title")
            }
            "29" -> {
                assetName = "29 Gorontalo.pdf"
                title = intent.getStringExtra("title")
            }
            "30" -> {
                assetName = "30 Maluku Utara.pdf"
                title = intent.getStringExtra("title")
            }
            "31" -> {
                assetName = "31 Maluku.pdf"
                title = intent.getStringExtra("title")
            }
            "32" -> {
                assetName = "32 Papua.pdf"
                title = intent.getStringExtra("title")
            }
        }

        val provMusik = intent.getIntExtra("musik", 0)
        pdfView.fromAsset(assetName)
            .spacing(5)
            .enableSwipe(true) // allows to block changing pages using swipe
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .load()

        titleKonten.text = title

    }
}