package com.eva.dikejar.ui.pendahuluan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentPendahuluan1Binding
import com.feylabs.lasagna.util.SharedPreference.Preferences


class Pendahuluan1Fragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val answers = binding.etAnswers.text.toString()
            if (answers.isEmpty()){
                Toast.makeText(requireContext(),"Isi Jawaban Terlebih Dahulu",Toast.LENGTH_LONG).show()
            }else{
                Preferences(requireContext()).save(Preferences.PENDAHULUAN1,"ok")
                findNavController().navigate(R.id.materi1)
            }

        }

    }


}