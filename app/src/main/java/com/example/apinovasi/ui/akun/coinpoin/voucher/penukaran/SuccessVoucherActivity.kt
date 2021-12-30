package com.example.apinovasi.ui.akun.coinpoin.voucher.penukaran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivitySuccessVoucherBinding
import com.example.apinovasi.ui.akun.coinpoin.rewards.RewardsSayaActivity
import com.example.apinovasi.utils.setStatusBarLight

class SuccessVoucherActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessVoucherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarLight(this)

        binding.btnRewards.setOnClickListener {
            startActivity(Intent(this, RewardsSayaActivity::class.java))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            finish()
        }
    }
}