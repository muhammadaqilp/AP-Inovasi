package com.example.apinovasi.ui.akun.loyalty.benefit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apinovasi.R
import com.example.apinovasi.data.BenefitEntity
import com.example.apinovasi.databinding.ActivityBenefitLoyaltyBinding
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight

class BenefitLoyaltyActivity : AppCompatActivity(), BenefitAdapter.OnItemBenefitClick {

    private lateinit var binding: ActivityBenefitLoyaltyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBenefitLoyaltyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.itemBenefit1.benefitRoot.setOnClickListener {
            val bottomSheet = BottomSheetLoyaltyDetail(this, DataDummy.generateBenefitSiswa())
            bottomSheet.show(supportFragmentManager, BenefitLoyaltyActivity::class.java.simpleName)
        }

        setRecyclerViewBintang()
        setRecyclerViewBerprestasi()
        setRecyclerViewJuara()
    }

    private fun setRecyclerViewBintang() {
        val benefit = DataDummy.generateBenefitBintang()
        val bintangAdapter = BenefitAdapter(this)
        bintangAdapter.setListBenefit(benefit)
        with(binding.rvBintang) {
            layoutManager = LinearLayoutManager(this@BenefitLoyaltyActivity)
            setHasFixedSize(true)
            adapter = bintangAdapter
        }
    }

    private fun setRecyclerViewBerprestasi() {
        val benefit = DataDummy.generateBenefitBerprestasi()
        val berprestasiAdapter = BenefitAdapter(this)
        berprestasiAdapter.setListBenefit(benefit)
        with(binding.rvBerprestasi) {
            layoutManager = LinearLayoutManager(this@BenefitLoyaltyActivity)
            setHasFixedSize(true)
            adapter = berprestasiAdapter
        }
    }

    private fun setRecyclerViewJuara() {
        val benefit = DataDummy.generateBenefitJuara()
        val juaraAdapter = BenefitAdapter(this)
        juaraAdapter.setListBenefit(benefit)
        with(binding.rvJuara) {
            layoutManager = LinearLayoutManager(this@BenefitLoyaltyActivity)
            setHasFixedSize(true)
            adapter = juaraAdapter
        }
    }

    override fun onItemClicked(benefit: BenefitEntity) {
        val bottomSheet = BottomSheetLoyaltyDetail(this, benefit)
        bottomSheet.show(supportFragmentManager, BenefitLoyaltyActivity::class.java.simpleName)
    }
}