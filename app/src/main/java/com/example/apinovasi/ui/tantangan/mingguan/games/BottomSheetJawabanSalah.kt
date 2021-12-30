package com.example.apinovasi.ui.tantangan.mingguan.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetJawabanSalahBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetJawabanSalah : BottomSheetDialogFragment() {

    private var _binding: BottomsheetJawabanSalahBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: CheckButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetJawabanSalahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener = activity as CheckButton
        with(binding) {
            btnUlangi.setOnClickListener { dismiss() }
            btnLanjut.setOnClickListener {
                listener.onNextButtonClicked(true)
                dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
}