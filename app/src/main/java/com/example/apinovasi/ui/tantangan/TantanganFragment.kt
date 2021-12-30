package com.example.apinovasi.ui.tantangan

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.apinovasi.R
import com.example.apinovasi.data.ChallengeEntity
import com.example.apinovasi.databinding.DialogCheckinBinding
import com.example.apinovasi.databinding.FragmentTantanganBinding
import com.example.apinovasi.ui.akun.loyalty.ProgressBarAnimation
import com.example.apinovasi.ui.tantangan.checkin.SuccessCheckinActivity
import com.example.apinovasi.ui.tantangan.harian.ChallengeHarianActivity
import com.example.apinovasi.ui.tantangan.harian.aplive.BottomSheetAPLive
import com.example.apinovasi.ui.tantangan.leaderboard.LeaderboardActivity
import com.example.apinovasi.ui.tantangan.mingguan.ChallengeMingguanActivity
import java.util.*
import kotlin.concurrent.schedule

class TantanganFragment : Fragment() {

    private var check: Boolean = false

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                if (data != null) {
                    check = true
                }
            }
        }

    private var _binding: FragmentTantanganBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTantanganBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDialog()

        binding.btnLeaderboard.setOnClickListener {
            startActivity(Intent(context, LeaderboardActivity::class.java))
        }

        binding.tvChallengeSemua.setOnClickListener {
            startActivity(Intent(context, ChallengeHarianActivity::class.java))
        }

        binding.itemChallengeHarian.cv1.setOnClickListener {
            val ch = ChallengeEntity(
                "Tonton 2 AP Live",
                "Minimal 2 Video AP Live",
                "1/2",
                "20",
                "10",
                R.drawable.ic_play
            )
            val bottomSheet = BottomSheetAPLive(requireActivity(), ch)
            bottomSheet.show(childFragmentManager, TantanganFragment::class.java.simpleName)
        }

        binding.btnMulai.setOnClickListener {
            startActivity(Intent(context, ChallengeMingguanActivity::class.java))
        }
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        val binding1 = DialogCheckinBinding.inflate(layoutInflater)
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding1.root)
        dialog.setCancelable(false)

        binding1.btnCheckin.setOnClickListener {
            val anim = ProgressBarAnimation(binding1.progressBar, 0F, 35F)
            anim.duration = 2000
            binding1.progressBar.startAnimation(anim)

            Timer().schedule(2500) {
                check = true
                val intent = Intent(context, SuccessCheckinActivity::class.java)
                resultLauncher.launch(intent)
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}