package com.example.apinovasi.ui.tantangan.mingguan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ActivityChallengeMingguanBinding
import com.example.apinovasi.ui.akun.loyalty.ProgressBarAnimation
import com.example.apinovasi.ui.tantangan.harian.aplive.SuccessAPLiveActivity
import com.example.apinovasi.ui.tantangan.mingguan.games.BottomSheetJawabanSalah
import com.example.apinovasi.ui.tantangan.mingguan.games.CheckButton
import com.example.apinovasi.utils.setStatusBarTransparentLight

class ChallengeMingguanActivity : AppCompatActivity(), CheckButton {

    private lateinit var binding: ActivityChallengeMingguanBinding
    private var position: Int = 0
    private var jawab: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeMingguanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { finish() }

        updateProgress(position.toFloat(), (position + 1).toFloat())
        binding.tvProgress.text =
            resources.getString(R.string.txt_jumlah_soal, position + 1, JAWABAN.size)

        val gamesAdapter = GamesPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = gamesAdapter

        binding.btnNext.setOnClickListener {
            if (checkJawaban(jawab)) {
                goToNext()
            } else {
                val bottomSheet = BottomSheetJawabanSalah()
                bottomSheet.show(
                    supportFragmentManager,
                    ChallengeMingguanActivity::class.java.simpleName
                )
            }
        }
    }

    private fun goToNext() {
        binding.viewPager.currentItem = position + 1
        position += 1
        if (position == 6) {
            val intent = Intent(this, SuccessAPLiveActivity::class.java)
            intent.putExtra(
                SuccessAPLiveActivity.EXTRA_TITLE,
                resources.getString(R.string.txt_berhasil_mingguan)
            )
            intent.putExtra(
                SuccessAPLiveActivity.EXTRA_BTN,
                resources.getString(R.string.txt_selesaikan_challenge)
            )
            startActivity(intent)
            finish()
        } else {
            updateProgress(position.toFloat(), (position + 1).toFloat())
            binding.tvProgress.text =
                resources.getString(R.string.txt_jumlah_soal, position + 1, JAWABAN.size)
            checkButton(false)
        }
    }

    private fun updateProgress(from: Float, to: Float) {
        val anim = ProgressBarAnimation(binding.progressBar, from, to)
        anim.duration = 2000
        binding.progressBar.startAnimation(anim)
    }

    override fun onButtonActive(status: Boolean, jawaban: String) {
        checkButton(status)
        jawab = jawaban
    }

    override fun onNextButtonClicked(status: Boolean) {
        if (status) {
            goToNext()
        }
    }

    private fun checkJawaban(jawaban: String): Boolean {
        val ans = jawaban.lowercase()
        return ans == JAWABAN[position]
    }

    private fun checkButton(status: Boolean) {
        if (status) {
            with(binding) {
                btnNext.background = ContextCompat.getDrawable(
                    this@ChallengeMingguanActivity,
                    R.drawable.bg_textview_blue
                )
                btnNext.setTextColor(
                    ContextCompat.getColor(
                        this@ChallengeMingguanActivity,
                        R.color.pure_white
                    )
                )
                btnNext.isClickable = true
                btnNext.isEnabled = true
            }
        } else {
            with(binding) {
                btnNext.background = ContextCompat.getDrawable(
                    this@ChallengeMingguanActivity,
                    R.color.bg_btn_incative
                )
                btnNext.setTextColor(
                    ContextCompat.getColor(
                        this@ChallengeMingguanActivity,
                        R.color.txt_btn_incative
                    )
                )
                btnNext.isClickable = false
                btnNext.isEnabled = false
            }
        }
    }

    companion object {
        private val JAWABAN = arrayOf(
            "lubang cacing",
            "anti bodi",
            "lorem ipsum",
            "go",
            "ohaus",
            "papua"
        )
    }
}