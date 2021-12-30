package com.example.apinovasi.ui.tantangan.harian.aplive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivityChallengeApliveBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class ChallengeAPLiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChallengeApliveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeApliveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }
        binding.ivLive1.setOnClickListener {
            val intent = Intent(this, SuccessAPLiveActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}