package com.example.apinovasi.ui.akun.coinpoin.voucher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apinovasi.data.VoucherEntity
import com.example.apinovasi.databinding.ActivityVoucherSemuaBinding
import com.example.apinovasi.ui.akun.coinpoin.voucher.detail.BottomSheetDetailVoucher
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight
import com.google.android.material.bottomsheet.BottomSheetDialog

class VoucherSemuaActivity : AppCompatActivity(), VoucherSemuaAdapter.OnVoucherClickCallback {

    private lateinit var binding: ActivityVoucherSemuaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoucherSemuaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        val voucher = DataDummy.generateVoucherData()
        val voucherAdapter = VoucherSemuaAdapter(this)
        voucherAdapter.setVoucherListSemua(voucher)
        with(binding.rvVoucher) {
            layoutManager = LinearLayoutManager(this@VoucherSemuaActivity)
            setHasFixedSize(true)
            adapter = voucherAdapter
        }

        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    override fun onVoucherClicked(voucher: VoucherEntity) {
        val bottomSheet = BottomSheetDetailVoucher(this, voucher)
        bottomSheet.show(supportFragmentManager, VoucherSemuaActivity::class.java.simpleName)
    }
}