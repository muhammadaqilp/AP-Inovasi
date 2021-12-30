package com.example.apinovasi.ui.akun.referral.teman_diundang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivityTemanDiundangBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class TemanDiundangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemanDiundangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemanDiundangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivShare.setOnClickListener { finish() }
    }
}