package com.example.apinovasi.ui.akun.coinpoin.histori

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ActivityCoinPoinHistoriBinding
import com.example.apinovasi.databinding.ItemLayoutFilterBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight
import com.google.android.material.tabs.TabLayoutMediator

class CoinPoinHistoriActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.ap_coin,
            R.string.ap_poin
        )
    }

    private lateinit var binding: ActivityCoinPoinHistoriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPoinHistoriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        val pagerAdapter = HistoriPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}