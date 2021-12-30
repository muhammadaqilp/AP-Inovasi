package com.example.apinovasi.ui.akun.coinpoin.histori.filter

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetFilterAppoinBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFilterPoin(private val activity: Activity) : BottomSheetDialogFragment() {

    private var _binding: BottomsheetFilterAppoinBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetFilterAppoinBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTerapkan.setOnClickListener { dismiss() }

        with(binding) {
            tvSemuaTransaksi.setOnClickListener {
                checkStatus(
                    tvSemuaTransaksi,
                    tvSemuaTransaksi.tag.toString()
                )
            }
            tvHadiah.setOnClickListener {
                checkStatus(
                    tvHadiah,
                    tvHadiah.tag.toString()
                )
            }
            tvExpired.setOnClickListener {
                checkStatus(
                    tvExpired,
                    tvExpired.tag.toString()
                )
            }
            tvTukarVoucher.setOnClickListener {
                checkStatus(
                    tvTukarVoucher,
                    tvTukarVoucher.tag.toString()
                )
            }
        }
    }

    private fun checkStatus(textView: TextView, tag: String) {
        if (tag == "unselected") {
            textView.setTextColor(ContextCompat.getColor(activity, R.color.pure_white))
            textView.background = ContextCompat.getDrawable(activity, R.drawable.bg_filter_sel)
            textView.tag = "selected"
        } else {
            textView.setTextColor(ContextCompat.getColor(activity, R.color.filter_unselected))
            textView.background = ContextCompat.getDrawable(activity, R.drawable.bg_filter_unsel)
            textView.tag = "unselected"
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