package com.eva.dikejar.ui.pratinjau

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentPratinjauBinding


class PratinjauFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var _binding : FragmentPratinjauBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPratinjauBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startMateri1.setOnClickListener {
        findNavController().navigate(R.id.konsep1Fragment)
        }

        binding.startMateri2.setOnClickListener {
            findNavController().navigate(R.id.konsep2Fragment)
        }

        binding.startMateri3.setOnClickListener {
            findNavController().navigate(R.id.konsep3Fragment)
        }
    }


}