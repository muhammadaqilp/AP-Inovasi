package com.example.apinovasi.ui.akun

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apinovasi.databinding.FragmentAkunBinding
import com.example.apinovasi.ui.akun.coinpoin.CoinPoinActivity
import com.example.apinovasi.ui.akun.loyalty.LoyaltyActivity
import com.example.apinovasi.ui.akun.referral.ReferralActivity

class AkunFragment : Fragment() {

    private lateinit var binding: FragmentAkunBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAkunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAjakTeman.setOnClickListener {
            val intent = Intent(requireContext(), ReferralActivity::class.java)
            startActivity(intent)
        }
        binding.lyCoin.setOnClickListener {
            val intent = Intent(requireContext(), CoinPoinActivity::class.java)
            startActivity(intent)
        }
        binding.lyPoin.setOnClickListener {
            val intent = Intent(requireContext(), CoinPoinActivity::class.java)
            intent.putExtra(CoinPoinActivity.EXTRA_CODE, 1)
            startActivity(intent)
        }
        binding.btnLoyalty.setOnClickListener {
            val intent = Intent(requireContext(), LoyaltyActivity::class.java)
            startActivity(intent)
        }
    }
}