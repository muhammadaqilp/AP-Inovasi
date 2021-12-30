package com.example.apinovasi.ui.akun.coinpoin.aksespremium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apinovasi.databinding.ActivityAksesPremiumSemuaBinding
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight

class AksesPremiumSemuaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAksesPremiumSemuaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAksesPremiumSemuaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        val akses = DataDummy.generateAksesPremiumData()
        val aksesAdapter = AksesPremiumSemuaAdapter()
        aksesAdapter.setAksesListSemua(akses)
        with(binding.rvAkses) {
            layoutManager = LinearLayoutManager(this@AksesPremiumSemuaActivity)
            setHasFixedSize(true)
            adapter = aksesAdapter
        }

        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}