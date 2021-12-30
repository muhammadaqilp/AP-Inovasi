package com.example.apinovasi.ui.akun.coinpoin.topup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetNominalTopupBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetNominalTopup(
    private val callback: OnBottomSheetCallback,
    private val position: Int
) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetNominalTopupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetNominalTopupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkPosition()
        with(binding) {
            nominal1.setOnClickListener {
                callback.onNominalClicked(1)
                dismiss()
            }
            nominal2.setOnClickListener {
                callback.onNominalClicked(2)
                dismiss()
            }
            nominal3.setOnClickListener {
                callback.onNominalClicked(3)
                dismiss()
            }
            nominal4.setOnClickListener {
                callback.onNominalClicked(4)
                dismiss()
            }
        }
    }

    private fun checkPosition() {
        with(binding) {
            when (position) {
                1 -> nominal1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0)
                2 -> nominal2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0)
                3 -> nominal3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0)
                4 -> nominal4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0)
                else -> return
            }
        }
    }

    interface OnBottomSheetCallback {
        fun onNominalClicked(position: Int)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}