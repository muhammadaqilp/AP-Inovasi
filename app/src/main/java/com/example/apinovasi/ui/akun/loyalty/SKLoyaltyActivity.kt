package com.example.apinovasi.ui.akun.loyalty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apinovasi.databinding.ActivitySkloyaltyBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SKLoyaltyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkloyaltyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkloyaltyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}