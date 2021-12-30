package com.example.apinovasi.ui.akun.coinpoin.topup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apinovasi.databinding.ActivitySuccessTopupBinding
import com.example.apinovasi.ui.akun.coinpoin.CoinPoinActivity
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SuccessTopupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessTopupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessTopupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.btnTukar.setOnClickListener {
            startActivity(Intent(this, CoinPoinActivity::class.java))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            finish()
        }
    }
}