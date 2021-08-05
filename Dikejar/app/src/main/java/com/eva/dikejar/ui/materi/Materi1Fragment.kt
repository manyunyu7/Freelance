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
import com.eva.dikejar.pdf.ViewPDFActivity
import com.feylabs.lasagna.util.SharedPreference.Preferences


class Materi1Fragment : Fragment() {

    var _binding: FragmentMateri1Binding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMateri1Binding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardPendahuluan.setOnClickListener {
            findNavController().navigate(R.id.action_materi1Fragment_to_pendahuluan1Fragment)
        }

        val pref = Preferences(requireContext()).getPrefString(Preferences.PENDAHULUAN1)
        if (pref == "ok") {
            binding.apply {
                gembok1.visibility = View.INVISIBLE
                gembok2.visibility = View.INVISIBLE
                gembok3.visibility = View.INVISIBLE
                gembok4.visibility = View.INVISIBLE
                gembok5.visibility = View.INVISIBLE
                gembok6.visibility = View.INVISIBLE

                binding.cardMateri1.setOnClickListener {
                    openPDF("1_1.pdf")
                }
                binding.cardMateri2.setOnClickListener {
                    openPDF("1_2.pdf")
                }
                binding.cardMateri3.setOnClickListener {
                    openPDF("1_3.pdf")
                }
                binding.cardMateri4.setOnClickListener {
                    openPDF("1_4.pdf")
                }
                binding.cardMateri5.setOnClickListener {
                    openPDF("1_5.pdf")
                }
                binding.cardMateri6.setOnClickListener {
                    openPDF("1_6.pdf")
                }
            }
        } else {
            binding.cardMateri1.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri2.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri3.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri4.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri5.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
            binding.cardMateri6.setOnClickListener {
                showToast("Selesaikan Pendahuluan Terlebih Dahulu")
            }
        }

        binding.finalExam.setOnClickListener {
            findNavController().navigate(R.id.penutupan1Fragment, bundleOf("type" to "1",))
        }


    }

    fun openPDF(filename: String) {
        startActivity(
            Intent(requireActivity(), ViewPDFActivity::class.java)
                .putExtra("file", filename)
        )
    }

    fun showToast(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }


}