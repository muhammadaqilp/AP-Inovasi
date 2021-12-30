package com.example.apinovasi.ui.tantangan.mingguan.games.pilihanganda

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.apinovasi.R
import com.example.apinovasi.databinding.FragmentPilihanGandaBinding
import com.example.apinovasi.ui.tantangan.mingguan.games.CheckButton

class PilihanGandaFragment : Fragment() {

    private var _binding: FragmentPilihanGandaBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: CheckButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPilihanGandaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = activity as CheckButton

        with(binding) {
            cv1.setOnClickListener {
                selectedOption(0)
                listener.onButtonActive(true, tvOpt1.text.toString())
            }
            cv2.setOnClickListener {
                selectedOption(1)
                listener.onButtonActive(true, tvOpt2.text.toString())
            }
            cv3.setOnClickListener {
                selectedOption(2)
                listener.onButtonActive(true, tvOpt3.text.toString())
            }
            cv4.setOnClickListener {
                selectedOption(3)
                listener.onButtonActive(true, tvOpt4.text.toString())
            }
        }
    }

    private fun selectedOption(position: Int) {
        val tv = arrayOf(
            binding.tvOpt1,
            binding.tvOpt2,
            binding.tvOpt3,
            binding.tvOpt4
        )
        for (i in 0..3) {
            tv[i].setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
            tv[i].background =
                ContextCompat.getDrawable(requireContext(), R.drawable.bg_button_radius)
            val font: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.roboto_regular)
            tv[i].typeface = font
        }
        tv[position].setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_blue))
        tv[position].background =
            ContextCompat.getDrawable(requireContext(), R.drawable.bg_blue_2dp)
        val font: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.roboto_medium)
        tv[position].typeface = font
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}