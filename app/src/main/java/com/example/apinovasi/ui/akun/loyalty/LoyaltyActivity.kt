package com.example.apinovasi.ui.akun.loyalty

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.HomeActivity
import com.example.apinovasi.databinding.ActivityLoyaltyBinding
import com.example.apinovasi.ui.akun.loyalty.benefit.BenefitLoyaltyActivity
import com.example.apinovasi.ui.akun.loyalty.benefit.BottomSheetLoyaltyDetail
import com.example.apinovasi.ui.tantangan.harian.aplive.SuccessAPLiveActivity
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight

class LoyaltyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoyaltyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoyaltyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.tvSk.setOnClickListener {
            val intent = Intent(this, SKLoyaltyActivity::class.java)
            startActivity(intent)
        }

        binding.layoutXp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(SuccessAPLiveActivity.EXTRA_HOME, 1)
            startActivity(intent)
            finish()
        }

        val anim = ProgressBarAnimation(binding.progressBar, 0F, 30F)
        anim.duration = 2000
        binding.progressBar.startAnimation(anim)

        binding.itemBenefit1.benefitRoot.setOnClickListener {
            val bottomSheet = BottomSheetLoyaltyDetail(this, DataDummy.generateBenefitSiswa())
            bottomSheet.show(supportFragmentManager, LoyaltyActivity::class.java.simpleName)
        }

        binding.tvBenefitSemua.setOnClickListener {
            startActivity(Intent(this, BenefitLoyaltyActivity::class.java))
        }
    }
}