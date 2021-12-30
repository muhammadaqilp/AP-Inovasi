package com.example.apinovasi.ui.tantangan.harian.aplive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.HomeActivity
import com.example.apinovasi.databinding.ActivitySuccessApliveBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SuccessAPLiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessApliveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessApliveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        if (intent.extras != null) {
            binding.tvSelesai.text = intent.getStringExtra(EXTRA_TITLE)
            binding.btnTutup.text = intent.getStringExtra(EXTRA_BTN)
        }

        binding.btnTutup.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EXTRA_HOME, 1)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_HOME = "extra_home"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_BTN = "extra_btn"
    }
}