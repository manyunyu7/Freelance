package com.eva.dikejar.ui.materi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentMateri1Binding
import com.eva.dikejar.databinding.FragmentMateri2Binding
import com.eva.dikejar.databinding.FragmentMateri3Binding
import com.eva.dikejar.pdf.ViewPDFActivity
import com.feylabs.lasagna.util.SharedPreference.Preferences


class Materi3Fragment : Fragment() {

    var _binding: FragmentMateri3Binding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMateri3Binding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardPendahuluan.setOnClickListener {
            findNavController().navigate(R.id.action_materi3Fragment_to_pendahuluan3Fragment)
        }

        val pref = Preferences(requireContext()).getPrefString(Preferences.PENDAHULUAN3)
        if (pref == "ok") {
            binding.apply {
                gembok1.visibility = View.INVISIBLE
                gembok2.visibility = View.INVISIBLE

                binding.cardMateri1.setOnClickListener {
                    openPDF("3_1.pdf")
                }
                binding.cardMateri2.setOnClickListener {
                    openPDF("3_2.pdf")
                }
                binding.finalExam.setOnClickListener {
                    findNavController().navigate(R.id.penutupan1Fragment, bundleOf("type" to "3"))
                }

            }
        } else {
            binding.cardMateri1.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri2.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.finalExam.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
        }




    }

    private fun openPDF(filename: String) {
        startActivity(
            Intent(requireActivity(), ViewPDFActivity::class.java)
                .putExtra("file", filename)
        )
    }

    private fun showToast(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }


}