package com.example.apinovasi.ui.akun.coinpoin.histori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apinovasi.databinding.FragmentCoinHistoriBinding
import com.example.apinovasi.ui.akun.coinpoin.histori.filter.BottomSheetFilterCoin
import com.example.apinovasi.ui.akun.coinpoin.histori.urutkan.BottomSheetUrutkan

class CoinHistoriFragment : Fragment() {

    private lateinit var binding: FragmentCoinHistoriBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoinHistoriBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutFAB.btnUrutkan.setOnClickListener {
            val bottomSheet = BottomSheetUrutkan()
            bottomSheet.show(childFragmentManager, CoinHistoriFragment::class.java.simpleName)
        }

        binding.layoutFAB.btnFilter.setOnClickListener {
            val bottomSheet = BottomSheetFilterCoin(requireActivity())
            bottomSheet.show(childFragmentManager, CoinHistoriFragment::class.java.simpleName)
        }
    }
}