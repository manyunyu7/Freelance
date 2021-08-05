package com.eva.dikejar.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentMenuVideo2Binding

class FragmentVideo2 : Fragment() {

    private var _binding : FragmentMenuVideo2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuVideo2Binding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chip1.setOnClickListener{
            findNavController().navigate(R.id.fragmentVideo1)
        }
        binding.chip2.setOnClickListener{
            findNavController().navigate(R.id.fragmentVideo2)
        }
        binding.chip3.setOnClickListener{
            findNavController().navigate(R.id.fragmentVideo3)
        }

    }

}