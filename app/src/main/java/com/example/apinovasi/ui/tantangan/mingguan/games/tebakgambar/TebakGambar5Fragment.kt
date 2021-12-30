package com.example.apinovasi.ui.tantangan.mingguan.games.tebakgambar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.apinovasi.R
import com.example.apinovasi.databinding.FragmentTebakGambar5Binding
import com.example.apinovasi.ui.tantangan.mingguan.games.CheckButton

class TebakGambar5Fragment : Fragment() {

    private var _binding: FragmentTebakGambar5Binding? = null
    private val binding get() = _binding!!
    private lateinit var listener: CheckButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTebakGambar5Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = activity as CheckButton

        with(binding) {
            cv1.setOnClickListener {
                selectedOption(0)
                listener.onButtonActive(true, cv1.tag.toString())
            }
            cv2.setOnClickListener {
                selectedOption(1)
                listener.onButtonActive(true, cv2.tag.toString())
            }
            cv3.setOnClickListener {
                selectedOption(2)
                listener.onButtonActive(true, cv3.tag.toString())
            }
            cv4.setOnClickListener {
                selectedOption(3)
                listener.onButtonActive(true, cv4.tag.toString())
            }
        }
    }

    private fun selectedOption(position: Int) {
        val cv = arrayOf(
            binding.cv1,
            binding.cv2,
            binding.cv3,
            binding.cv4
        )
        for (i in 0..3) {
            cv[i].foreground =
                ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_transparent)
        }
        cv[position].foreground =
            ContextCompat.getDrawable(requireContext(), R.drawable.bg_blue_2dp)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}