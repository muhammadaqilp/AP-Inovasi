package com.example.apinovasi.ui.akun.coinpoin

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apinovasi.HomeActivity
import com.example.apinovasi.R
import com.example.apinovasi.data.VoucherEntity
import com.example.apinovasi.databinding.ActivityCoinPoinBinding
import com.example.apinovasi.ui.akun.coinpoin.aksespremium.AksesPremiumAdapter
import com.example.apinovasi.ui.akun.coinpoin.aksespremium.AksesPremiumSemuaActivity
import com.example.apinovasi.ui.akun.coinpoin.histori.CoinPoinHistoriActivity
import com.example.apinovasi.ui.akun.coinpoin.rewards.RewardsSayaActivity
import com.example.apinovasi.ui.akun.coinpoin.voucher.VoucherAdapter
import com.example.apinovasi.ui.akun.coinpoin.voucher.VoucherSemuaActivity
import com.example.apinovasi.ui.akun.coinpoin.voucher.detail.BottomSheetDetailVoucher
import com.example.apinovasi.ui.tantangan.harian.aplive.SuccessAPLiveActivity
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight
import com.google.android.material.tabs.TabLayoutMediator


class CoinPoinActivity : AppCompatActivity(), VoucherAdapter.OnVoucherClick {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.ap_coin,
            R.string.ap_poin
        )

        const val EXTRA_CODE = "extra_code"
    }

    private lateinit var binding: ActivityCoinPoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)
        binding.viewStatusBar.layoutParams =
            ViewGroup.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, getStatusBarHeight())

        val getCode = intent.extras

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        if (getCode != null) {
            binding.viewPager.currentItem = 1
        }
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.btnRiwayat.setOnClickListener {
            val intent = Intent(this, CoinPoinHistoriActivity::class.java)
            startActivity(intent)
        }

        val akses = DataDummy.generateAksesPremiumData()
        val aksesAdapter = AksesPremiumAdapter()
        aksesAdapter.setAksesList(akses)
        with(binding.rvAkses) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = aksesAdapter
        }

        val voucher = DataDummy.generateVoucherData()
        val voucherAdapter = VoucherAdapter(this)
        voucherAdapter.setVoucherList(voucher)
        with(binding.rvVoucher) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = voucherAdapter
        }

        binding.tvAksesSemua.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AksesPremiumSemuaActivity::class.java
                )
            )
        }

        binding.tvVoucherSemua.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    VoucherSemuaActivity::class.java
                )
            )
        }

        binding.fabRewards.setOnClickListener {
            startActivity(Intent(this, RewardsSayaActivity::class.java))
        }

        binding.layoutXp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(SuccessAPLiveActivity.EXTRA_HOME, 1)
            startActivity(intent)
            finish()
        }
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    override fun onVoucherClicked(voucher: VoucherEntity) {
        val bottomSheet = BottomSheetDetailVoucher(this, voucher)
        bottomSheet.show(supportFragmentManager, CoinPoinActivity::class.java.simpleName)
    }
}
