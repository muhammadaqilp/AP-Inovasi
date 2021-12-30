package com.example.apinovasi.ui.akun.coinpoin.voucher.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.apinovasi.R
import com.example.apinovasi.data.VoucherEntity
import com.example.apinovasi.databinding.BottomsheetVoucherDetailBinding
import com.example.apinovasi.ui.akun.coinpoin.voucher.penukaran.PenukaranVoucherActivity
import com.example.apinovasi.utils.StringUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDetailVoucher(private val activity: Activity, private val voucher: VoucherEntity) :
    BottomSheetDialogFragment() {

    private var _binding: BottomsheetVoucherDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetVoucherDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitle.text = voucher.titleVoucher
            tvProvider.text = voucher.providerVoucher
            tvJumlahCoin.text = voucher.coinVoucher
            tvJumlahPoin.text = voucher.poinVoucher

            Glide.with(activity)
                .load(voucher.posterVoucher)
                .into(ivPoster)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
}