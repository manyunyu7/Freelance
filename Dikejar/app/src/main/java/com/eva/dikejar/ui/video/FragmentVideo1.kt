package com.eva.dikejar.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentMenuVideo1Binding


class FragmentVideo1 : Fragment() {

    private var _binding: FragmentMenuVideo1Binding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding  = FragmentMenuVideo1Binding.inflate(inflater,container,false)
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

          binding.vid1.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid1.mp4")
            )
        }

          binding.vid2.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid2.mp4")
            )
        }

          binding.vid3.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid3.mp4")
            )
        }

          binding.vid4.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid4.mp4")
            )
        }

          binding.vid5.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid5.mp4")
            )
        }

          binding.vid6.setOnClickListener {
            findNavController().navigate(
                R.id.videoPlayerFragment,
                bundleOf("url" to "$baseURL/vid6.mp4")
            )
        }


    }

}