package com.eva.dikejar.ui.materi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentMateri1Binding
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

                }
                binding.cardMateri1.setOnClickListener {

                }
                binding.cardMateri1.setOnClickListener {

                }
                binding.cardMateri1.setOnClickListener {

                }
                binding.cardMateri1.setOnClickListener {

                }
            }
        } else {
            // Do Literally Nothing
        }


    }


}