package com.eva.dikejar.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentListVideoBinding

class ListVideoFragment : Fragment() {


    var _binding: FragmentListVideoBinding? = null
    val binding get() = _binding!!

    val adapter1 by lazy { ListVideoRecyclerViewAdapter() }
    val adapter2 by lazy { ListVideoRecyclerViewAdapter() }
    val adapter3 by lazy { ListVideoRecyclerViewAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListVideoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val baseURL = "https://kelurahan-bojongsari.net/ringkas/"  //jangan dihapus untuk video

        val videoData1 = mutableListOf<VideoModel>(
            VideoModel(
                "Komponen  Komputer & Spesifikasi PC  & Spesifikasi PC",
                "$baseURL/vid1.mp4"
            ),
            VideoModel("Alat dan Bahan Merakit Komputer  ", "$baseURL/vid2.mp4"),
            VideoModel("Prosedur Merakit Komputer CPU  ", "$baseURL/vid3.mp4"),
            VideoModel("Pemasangan Motherboard pada Cassing", "$baseURL/vid4.mp4"),
            VideoModel(
                "Pemasangan Kartu Video, Kartu Suara dan Kartu Jaringan",
                "$baseURL/vid5.mp4"
            ),
            VideoModel("Pemasangan Konektor ke Perangkat Input dan Output", "$baseURL/vid6.mp4"),
        )

        val videoData2 = mutableListOf<VideoModel>(
            VideoModel("Pengertian Beep Code BIOS", "$baseURL/vid7.mp4"),
            VideoModel("Jenis Beep Code POST BIOS dan Artinya  ", "$baseURL/vid8.mp4"),
            VideoModel(
                "Pengecekan Perangkat Input, Proses, Output, dan Media Penyimpanan pada BIOS",
                "$baseURL/vid9.mp4"
            ),
        )

        val videoData3 = mutableListOf<VideoModel>(
            VideoModel("Konfigurasi BIOS pada Komputer", "$baseURL/vid10.mp4"),
            VideoModel("Setting BIOS", "$baseURL/vid11.mp4"),
        )

        adapter1.setData(videoData1)
        adapter2.setData(videoData2)
        adapter3.setData(videoData3)

        adapter1.setInterface(object : ListVideoRecyclerViewAdapter.VideoInterface {
            override fun onclick(model: VideoModel) {
                findNavController().navigate(
                    R.id.videoPlayerFragment,
                    bundleOf("url" to model.url)
                )
            }

        })
        adapter2.setInterface(object : ListVideoRecyclerViewAdapter.VideoInterface {
            override fun onclick(model: VideoModel) {
                findNavController().navigate(
                    R.id.videoPlayerFragment,
                    bundleOf("url" to model.url)
                )
            }
        })
        adapter3.setInterface(object : ListVideoRecyclerViewAdapter.VideoInterface {
            override fun onclick(model: VideoModel) {
                findNavController().navigate(
                    R.id.videoPlayerFragment,
                    bundleOf("url" to model.url)
                )
            }
        })

        binding.rvVideo1.apply {
            adapter = adapter1
            layoutManager = LinearLayoutManager(requireContext())
            adapter1.notifyDataSetChanged()
        }

        binding.rvVideo2.apply {
            adapter = adapter2
            layoutManager = LinearLayoutManager(requireContext())
            adapter2.notifyDataSetChanged()
        }

        binding.rvVideo3.apply {
            adapter = adapter3
            layoutManager = LinearLayoutManager(requireContext())
            adapter3.notifyDataSetChanged()
        }


    }


}