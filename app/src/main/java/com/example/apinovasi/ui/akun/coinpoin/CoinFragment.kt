package com.example.apinovasi.ui.akun.coinpoin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apinovasi.databinding.FragmentCoinBinding
import com.example.apinovasi.ui.akun.coinpoin.topup.TopUpCoinActivity

class CoinFragment : Fragment() {

    private lateinit var binding: FragmentCoinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoinBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSk.setOnClickListener {
            val intent = Intent(context, SKCoinPoinActivity::class.java)
            intent.putExtra(SKCoinPoinActivity.EXTRA_CODE, "coin")
            startActivity(intent)
        }

        binding.btnTopup.setOnClickListener {
            startActivity(Intent(context, TopUpCoinActivity::class.java))
        }
    }

}