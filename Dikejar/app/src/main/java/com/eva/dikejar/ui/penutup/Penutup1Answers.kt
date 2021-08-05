package com.eva.dikejar.ui.penutup

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentPenutup1AnswersBinding
import com.eva.dikejar.databinding.FragmentPenutupan1Binding


class Penutup1Answers : Fragment() {

    var _binding: FragmentPenutup1AnswersBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPenutup1AnswersBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            etAnswers1.inputType=InputType.TYPE_NULL
            etAnswers2.inputType = InputType.TYPE_NULL

            val userAnswers1 = arguments?.getString("answers1")
            val userAnswers2 = arguments?.getString("answers2")
            val type = arguments?.getString("type")

            etAnswers1.setText(userAnswers1)
            etAnswers2.setText(userAnswers2)

            when (type) {
                "1" -> {
                    tvSoal1.text = "1.\tBagaimana cara mengidentifikasi pemasangan RAM pada motherboard sudah terpasang dengan baik?"
                    tvSoal2.text = "2.\tLangkah yang paling akhirsetelah perakitan komputer sebelum menyalakan listrik adalah menghubungkan peralatan dasar I/O. Sebutkan peralatan apa saja yang harus disampungkan!"
                    answers1.text = "yaitu pada saat mengunci RAM pada motherboard, apabila RAM terpasang dengan baik saat mengunci maka terdapat bunyi “klik” pada RAM tersebut. Sedangkan apabia RAM tidak terpasang dengan baik maka komputer akan berbunyi menandakan RAM belum terpasang sempurna."
                    answers2.text = "sambungkan keyboard pada bagian belakang case, sambungkan mouse pada bagian belakang case, sambungkan kabel power pada monitor, power supply utama."
                }
                "2" -> {
                    tvSoal1.text = "1.\tBagaimana cara mengetahui sebuah komputer berhasil atau tidak melakukan POST?"
                    tvSoal2.text = "2.\tBeep code merupakan tanda awal hardware yang dilakukan BIOS komputer. Apakah fungsi beep code bagi user?"
                    answers1.text="apabila komputer berhasil melakukan POST akan mengeluarkan suara beep tunggal sebagai tanda komputer menyala dengan normal. Apabila komputer gagal melakukan POST, komputer tidak akan mengeluarkan bunyi beep sama sekali."
                    answers2.text="untuk memudahkan pengguna dalam mengecek komponen mana dari komputer yang memiliki kerusakan."
                }
                "3" -> {
                    tvSoal1.text = "1.\tAgar BIOS dapat menjalankan tugasnya dengan baik, dibutuhkan beberapa komponen pendukung. Apa saja komponen – komponen BIOS tersebut?"
                    tvSoal2.text = "2.\tBagaimana cara menyeting BIOS, supaya PC dapat bekerja dengan optimal?"
                    answers1.text="program BIOS setup, Driver, dan program bootstrapper utama."
                    answers2.text="Pengesetan setting pada BIOS diisi secara manual sesuai dengan spesifikasi komponen  dan peralaan yang terpasang. Bagian setting peralatan yang tidak ada di-setting disable atau none. Dengan demikian kerja komputer akan lebih cepat"
                }
            }

        }


    }


}