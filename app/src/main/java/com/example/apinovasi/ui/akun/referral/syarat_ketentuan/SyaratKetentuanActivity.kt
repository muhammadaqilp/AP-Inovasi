package com.example.apinovasi.ui.akun.referral.syarat_ketentuan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivitySyaratKetentuanBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SyaratKetentuanActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySyaratKetentuanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySyaratKetentuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}