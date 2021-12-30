package com.example.apinovasi.ui.akun.coinpoin.rewards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivityRewardsSayaBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class RewardsSayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRewardsSayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsSayaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.cv1.setOnClickListener {
            val bottomSheet = BottomSheetReward(this)
            bottomSheet.show(supportFragmentManager, RewardsSayaActivity::class.java.simpleName)
        }
    }
}