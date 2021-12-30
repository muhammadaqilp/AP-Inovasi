package com.example.apinovasi.ui.tantangan.checkin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apinovasi.databinding.ActivitySuccessCheckinBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class SuccessCheckinActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessCheckinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessCheckinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivExit.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}