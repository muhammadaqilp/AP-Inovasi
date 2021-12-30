package com.example.apinovasi.ui.akun.coinpoin.histori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.apinovasi.databinding.FragmentPoinHistoriBinding
import com.example.apinovasi.ui.akun.coinpoin.histori.filter.BottomSheetFilterPoin
import com.example.apinovasi.ui.akun.coinpoin.histori.urutkan.BottomSheetUrutkan

class PoinHistoriFragment : Fragment() {

    private lateinit var binding: FragmentPoinHistoriBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPoinHistoriBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutFAB.btnUrutkan.setOnClickListener {
            val bottomSheet = BottomSheetUrutkan()
            bottomSheet.show(childFragmentManager, CoinHistoriFragment::class.java.simpleName)
        }

        binding.layoutFAB.btnFilter.setOnClickListener {
            val bottomSheet = BottomSheetFilterPoin(requireActivity())
            bottomSheet.show(childFragmentManager, PoinHistoriFragment::class.java.simpleName)
        }
    }
}