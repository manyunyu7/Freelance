package com.eva.dikejar.ui.evaluasi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eva.dikejar.R
import com.eva.dikejar.databinding.FragmentEvaluasi1RakitBinding


class EvaluasiFragment_1_Rakit : Fragment() {


    private var _binding: FragmentEvaluasi1RakitBinding? = null
    private val binding get() = _binding!!

    var correctAnswers = mutableListOf<String>(

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val mapAnswer = mutableMapOf<String, String>(
        "1" to "0",
        "2" to "0",
        "3" to "0",
        "4" to "0",
        "5" to "0",
        "6" to "0",
        "7" to "0",
        "8" to "0",
        "9" to "0",
        "10" to "0",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEvaluasi1RakitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        correctAnswers = mutableListOf(
            requireContext().getString(R.string.answers_1_1_1),
            requireContext().getString(R.string.answers_1_2_4),
            requireContext().getString(R.string.answers_1_3_3),
            requireContext().getString(R.string.answers_1_4_2),
            requireContext().getString(R.string.answers_1_5_1),
            requireContext().getString(R.string.answers_1_6_1),
            requireContext().getString(R.string.answers_1_7_3),
            requireContext().getString(R.string.answers_1_8_2),
            requireContext().getString(R.string.answers_1_9_4),
            requireContext().getString(R.string.answers_1_10_2),
        )
//      #1
        binding.question1.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question1.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("1", text)

        }
//      #2
        binding.question2.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question2.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("2", text)
        }

//      #3
        binding.question3.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question3.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("3", text)
        }

//      #4
        binding.question4.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question4.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("4", text)
        }
//      #5
        binding.question5.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question5.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("5", text)
        }
//      #6
        binding.question6.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question6.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("6", text)
        }
//      #7
        binding.question7.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question7.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("7", text)
        }
//      #8
        binding.question8.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question8.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("8", text)
        }

//      #9
        binding.question9.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question9.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("9", text)
        }

//        #10
        binding.question10.setOnCheckedChangeListener { group, checkedId ->
            val selectedId: Int = binding.question10.checkedRadioButtonId
            // find the radiobutton by returned id
            val radioButton = requireActivity().findViewById(selectedId) as RadioButton
            val text = radioButton.text.toString()
            mapAnswer.put("10", text)
        }

        binding.btnCheckResult.setOnClickListener {
            binding.tvKey.text = ""

            var counter = 0
            var wrongCounter = 0
            var correctCounter = 0

            mapAnswer.forEach {
                if (it.value == "0") {
                    wrongCounter++
                }


                binding.tvKey.text=binding.tvKey.text.toString() + "\n ${counter+1}. " + correctAnswers[counter]

                if (it.value == correctAnswers[counter]) {
                    correctCounter++
                }
                counter++
            }

            Toast.makeText(requireContext(), "Nilai Anda $correctCounter", Toast.LENGTH_LONG).show()
            binding.tvSkor.setText("Skor Anda : ${correctCounter*10}")

        }



    }


}