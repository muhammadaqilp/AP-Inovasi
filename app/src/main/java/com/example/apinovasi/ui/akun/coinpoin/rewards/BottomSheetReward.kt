package com.example.apinovasi.ui.akun.coinpoin.rewards

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetRewardsBinding
import com.example.apinovasi.ui.akun.coinpoin.voucher.penukaran.PenukaranVoucherActivity
import com.example.apinovasi.utils.StringUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetReward(private val activity: Activity) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetRewardsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetRewardsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvSk.text = StringUtils.fromHtml(resources.getString(R.string.txt_sk_voucher))
            tvPenggunaan.text =
                StringUtils.fromHtml(resources.getString(R.string.txt_penggunaan_voucher))

            btnTutup.setOnClickListener { dismiss() }
            btnTukar.setOnClickListener {
                startActivity(
                    Intent(
                        activity,
                        PenukaranVoucherActivity::class.java
                    )
                )
                activity.finish()
            }
        }
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}