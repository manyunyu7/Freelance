package com.eva.dikejar.ui.penutup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentPenutupan1Binding

class Penutupan1Fragment : Fragment() {

    var _binding: FragmentPenutupan1Binding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPenutupan1Binding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = arguments?.getString("type")

        if (type == "1") {

        }

        if (type == "2") {
            binding.tvSoal1.text =
                "1.\tBagaimana cara mengetahui sebuah komputer berhasil atau tidak melakukan POST?"
            binding.tvSoal2.text =
                "2.\tBeep code merupakan tanda awal hardware yang dilakukan BIOS komputer. Apakah fungsi beep code bagi user?"
        }

        if (type == "3") {
            binding.tvSoal1.text =
                "1.\t1.\tAgar BIOS dapat menjalankan tugasnya dengan baik, dibutuhkan beberapa komponen pendukung. Apa saja komponen – komponen BIOS tersebut?"
            binding.tvSoal2.text =
                "2.\t2.\tBagaimana cara menyeting BIOS, supaya PC dapat bekerja dengan optimal?"
        }

        binding.btnSubmit.setOnClickListener {
            val answers1 = binding.etAnswers1.text.toString()
            val answers2 = binding.etAnswers1.text.toString()
            var isError = false

            if (answers1.isEmpty()) {
                isError = true
            }
            if (answers2.isEmpty()) {
                isError = true
            }

            if (isError) {
                Toast.makeText(
                    requireContext(),
                    "Lengkapi Jawaban Terlebih Dahulu",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                findNavController().navigate(
                    R.id.penutup1Answers, bundleOf(
                        "type" to type,
                        "answers1" to answers1,
                        "answers2" to answers2
                    )
                )
            }

        }
    }

}