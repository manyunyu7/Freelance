package com.eva.dikejar.ui.pendahuluan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentPendahuluan1Binding


class Pendahuluan3Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var _binding : FragmentPendahuluan1Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPendahuluan1Binding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


}