package com.example.apinovasi.ui.akun.coinpoin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivitySkcoinPoinBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SKCoinPoinActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CODE = "extra_code"
    }

    private lateinit var binding: ActivitySkcoinPoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkcoinPoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        val code = intent.extras

        if (code != null) {
            focusOnView()
        }

        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun focusOnView() {
        with(binding) {
            scrollView.post { scrollView.smoothScrollTo(0, txtApcoin.bottom) }
        }
    }
}