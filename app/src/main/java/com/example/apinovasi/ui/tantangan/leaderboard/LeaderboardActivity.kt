package com.example.apinovasi.ui.tantangan.leaderboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivityLeaderboardBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class LeaderboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeaderboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}