package com.eva.dikejar.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentMenuVideo3Binding


class FragmentVideo3 : Fragment() {

    private var _binding: FragmentMenuVideo3Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuVideo3Binding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
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

        val baseURL = "https://kelurahan-bojongsari.net/ryy/"  //jangan dihapus untuk video
        binding.vid8.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid8.mp4")
            )
        }
        binding.vid9.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid9.mp4")
            )
        }

    }


}