package com.example.apinovasi.ui.akun.coinpoin.voucher.penukaran

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ActivityPenukaranVoucherBinding
import com.example.apinovasi.databinding.DialogConfirmationVoucherBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class PenukaranVoucherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPenukaranVoucherBinding
    private var isSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenukaranVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        checkButton(isSelected)

        binding.cvCoin.setOnClickListener {
            binding.cvPoin.tag = "unselected"
            unselectedItem(binding.btnCirclePoin)
            clickItem(binding.cvCoin, binding.btnCircle)
        }

        binding.cvPoin.setOnClickListener {
            binding.cvCoin.tag = "unselected"
            unselectedItem(binding.btnCircle)
            clickItem(binding.cvPoin, binding.btnCirclePoin)
        }

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.btnTukar.setOnClickListener {
            if (isSelected) {
                showConfirmDialog()
            } else {
//                binding.btnTukar.isEnabled = false
//                binding.btnTukar.isClickable = false
            }
        }
    }

    private fun showConfirmDialog() {
        val dialog = Dialog(this)
        val binding1 = DialogConfirmationVoucherBinding.inflate(layoutInflater)
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding1.root)
        dialog.setCancelable(false)
        binding1.btnTukar.setOnClickListener {
            startActivity(Intent(this, SuccessVoucherActivity::class.java))
            finish()
            dialog.dismiss()
        }
        binding1.btnTutup.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun clickItem(cardView: CardView, btn: Button) {
        if (cardView.tag == "unselected") {
            btn.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_sel)
            cardView.tag = "selected"
            isSelected = true
            checkButton(isSelected)
        } else {
            btn.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unsel)
            cardView.tag = "unselected"
            isSelected = false
            checkButton(isSelected)
        }
    }

    private fun unselectedItem(btn: Button) {
        btn.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unsel)
        isSelected = false
        checkButton(isSelected)
    }

    private fun checkButton(status: Boolean) {
        if (!status) {
            with(binding) {
                btnTukar.background = ContextCompat.getDrawable(
                    this@PenukaranVoucherActivity,
                    R.color.bg_btn_incative
                )
                btnTukar.setTextColor(
                    ContextCompat.getColor(
                        this@PenukaranVoucherActivity,
                        R.color.txt_btn_incative
                    )
                )
            }
        } else {
            with(binding) {
                btnTukar.background = ContextCompat.getDrawable(
                    this@PenukaranVoucherActivity,
                    R.drawable.bg_textview_blue
                )
                btnTukar.setTextColor(
                    ContextCompat.getColor(
                        this@PenukaranVoucherActivity,
                        R.color.pure_white
                    )
                )
            }
        }
    }
}