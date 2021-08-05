package com.eva.dikejar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtAllVideo.setOnClickListener {
            findNavController().navigate(R.id.fragmentVideo1)
        }

        binding.includedEval.apply {
            btnTestRakit.setOnClickListener {
                findNavController().navigate(R.id.evaluasiFragment1, bundleOf("type" to "eval1"))
            }
            btnTestUjiKinerja.setOnClickListener {
                findNavController().navigate(R.id.evaluasiFragment2, bundleOf("type" to "eval2"))
            }
            btnTestUjiKonfigurasi.setOnClickListener {
                findNavController().navigate(R.id.evaluasiFragment3, bundleOf("type" to "eval3"))
            }
        }

        binding.includeMateri.apply {
            startMateri1.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_materi1Fragment, bundleOf("type" to "eval1"))
            }

            startMateri2.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_materi2Fragment, bundleOf("type" to "eval1"))
            }
        }


    }
}