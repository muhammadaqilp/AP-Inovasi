package com.example.apinovasi.ui.akun.coinpoin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetFilterApcoinBinding
import com.example.apinovasi.databinding.FragmentPoinBinding

class PoinFragment : Fragment() {

    private lateinit var binding: FragmentPoinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPoinBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSk.setOnClickListener {
            startActivity(Intent(context, SKCoinPoinActivity::class.java))
        }
    }

}