package com.example.apinovasi.ui.akun.loyalty.benefit

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.apinovasi.R
import com.example.apinovasi.data.BenefitEntity
import com.example.apinovasi.databinding.BottomsheetBenefitDetailBinding
import com.example.apinovasi.utils.StringUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetLoyaltyDetail(private val activity: Activity, private val benefit: BenefitEntity) :
    BottomSheetDialogFragment() {

    private var _binding: BottomsheetBenefitDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetBenefitDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemBenefit.tvTitle.text = benefit.title
        binding.itemBenefit.tvBenefit.text = benefit.description
        binding.tvKetentuan.text =
            StringUtils.fromHtml(resources.getString(R.string.txt_ketentuankhusus_loyalty))
        Glide.with(this.activity)
            .load(benefit.image)
            .into(binding.itemBenefit.ivIcon)
        binding.tvSk.setOnClickListener { dismiss() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}