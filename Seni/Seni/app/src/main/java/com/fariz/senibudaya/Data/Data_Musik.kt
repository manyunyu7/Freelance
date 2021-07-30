package com.fariz.senibudaya.Data

import com.fariz.seni.R


object musikDatas {
    private val musikNames = arrayOf(
        "1. Aceh",//1
        "2. Sumatera Utara",//2
        "3. Sumatera Barat",//3
        "4. Riau",//4
        "5. Jambi",//5
        "6. Sumatera Selatan",//6
        "7. Bengkulu",//7
        "8. Lampung",//8
        "9. Kepulauan Bangka Belitung",//9
        "10. Kepulauan Riau",//10
        "11. Jakarta",//11
        "12. Jawa Barat",//12
        "13. Banten",//13
        "14. Jawa Tengah",//14
        "15. Yogyakarta",//14
        "16. Jawa Timur",//16
        "17. Bali",//17
        "18. Nusa Tenggara Barat",//18
        "19. Nusa Tenggara Timur",//19
        "20. Kalimantan Barat",//20
        "21. Kalimantan Timur",//21
        "22. Kalimantan Selatan",//22
        "23. Kalimantan Tengah",//23
        "24. Sulawesi Utara",//24
        "25. Sulawesi Tengah",//25
        "26. Sulawesi Tenggara",//26
        "27. Sulawesi Selatan",//27
        "28. Sulawesi Barat",//28
        "29. Gorontalo",//29
        "30. Maluku Utara",//30
        "31. Maluku",//31
        "32. Papua"//32
    )

    private val musikDetails = arrayOf(
     "", "", "", "",
     "", "", "", "", "",
     "", "", "", "", "",
     "", "", "", "", "",
     "", "", "", "", "",
     "", "", "", "", "",
     "", "", "", "", ""
    )
    private val musikImages = intArrayOf(
        R.drawable.tari_1,
        R.drawable.tari_2,
        R.drawable.tari_3,
        R.drawable.tari_4,
        R.drawable.tari_5,
        R.drawable.tari_6,
        R.drawable.tari_7,
        R.drawable.tari_8,
        R.drawable.tari_9,
        R.drawable.tari_10,
        R.drawable.tari_11,
        R.drawable.tari_12,
        R.drawable.tari_13,
        R.drawable.tari_14,
        R.drawable.tari_15,
        R.drawable.tari_16,
        R.drawable.tari_17,
        R.drawable.tari_18,
        R.drawable.tari_19,
        R.drawable.tari_20,
        R.drawable.tari_21,
        R.drawable.tari_22,
        R.drawable.tari_23,
        R.drawable.tari_24,
        R.drawable.tari_25,
        R.drawable.tari_26,
        R.drawable.tari_27,
        R.drawable.tari_28,
        R.drawable.tari_29,
        R.drawable.tari_30,
        R.drawable.tari_31,
        R.drawable.tari_32,
        R.drawable.tari_33,
        R.drawable.tari_34
    )

    val listMusik: ArrayList<Musik>
        get() {
            val list = arrayListOf<Musik>()
            for (position in musikNames.indices) {
                val music = Musik()
                music.name = musikNames[position].toString()
                music.detail = musikDetails[position].toString()
                music.images = musikImages[position]
                list.add(music)
            }
            return list
        }
}

data class Musik(
    var name: String = "",
    var detail: String = "",
    var images: Int = 0
)