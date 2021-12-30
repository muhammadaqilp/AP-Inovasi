package com.example.apinovasi.ui.tantangan.harian.aplive

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.apinovasi.R
import com.example.apinovasi.data.ChallengeEntity
import com.example.apinovasi.databinding.BottomsheetBenefitApliveBinding
import com.example.apinovasi.ui.akun.loyalty.SKLoyaltyActivity
import com.example.apinovasi.utils.StringUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetAPLive(private val activity: Activity, private val challenge: ChallengeEntity) :
    BottomSheetDialogFragment() {

    private var _binding: BottomsheetBenefitApliveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetBenefitApliveBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitle.text = challenge.title
            tvDeskripsi.text = challenge.description
            tvPrgress.text = resources.getString(R.string.txt_progress, challenge.progress)
            tvPenyelesaian.text =
                StringUtils.fromHtml(resources.getString(R.string.txt_aplive_penyelesaian))
            Glide.with(activity)
                .load(challenge.image)
                .into(ivPoster)
            btnBuka.setOnClickListener {
                startActivity(
                    Intent(
                        activity,
                        ChallengeAPLiveActivity::class.java
                    )
                )
            }

            btnTutup.setOnClickListener {
                val intent = Intent(context, SKLoyaltyActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}