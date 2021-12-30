package com.example.apinovasi.ui.akun.coinpoin.topup

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ActivityTopUpCoinBinding
import com.example.apinovasi.databinding.DialogConfirmationTopupBinding
import com.example.apinovasi.utils.setStatusBarTransparentLight

class TopUpCoinActivity : AppCompatActivity(), BottomSheetNominalTopup.OnBottomSheetCallback {

    private lateinit var binding: ActivityTopUpCoinBinding
    private var isSelected = false
    private var nominalSelected = false
    private var position = 0
    private var metodeBayar: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopUpCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        checkButton(isSelected, nominalSelected)

        binding.ivBack.setOnClickListener { onBackPressed() }

        binding.tvNominal.setOnClickListener {
            val bottomSheet = BottomSheetNominalTopup(this, position)
            bottomSheet.show(supportFragmentManager, TopUpCoinActivity::class.java.simpleName)
        }

        binding.cvDana.setOnClickListener {
            unselectedAnotherItem(
                binding.btnCircleGopay,
                binding.btnCircleOvo,
                binding.cvGopay,
                binding.cvOvo
            )
            clickItem(binding.cvDana, binding.btnCircleDana)
            metodeBayar = "Dana"
        }

        binding.cvOvo.setOnClickListener {
            unselectedAnotherItem(
                binding.btnCircleGopay,
                binding.btnCircleDana,
                binding.cvGopay,
                binding.cvDana
            )
            clickItem(binding.cvOvo, binding.btnCircleOvo)
            metodeBayar = "OVO"
        }

        binding.cvGopay.setOnClickListener {
            unselectedAnotherItem(
                binding.btnCircleDana,
                binding.btnCircleOvo,
                binding.cvDana,
                binding.cvOvo
            )
            clickItem(binding.cvGopay, binding.btnCircleGopay)
            metodeBayar = "Gopay"
        }

        binding.btnTukar.setOnClickListener {
            if (isSelected) {
                showConfirmDialog()
            } else {
                //isi apakek
            }
        }
    }

    private fun showConfirmDialog() {
        val dialog = Dialog(this)
        val binding1 = DialogConfirmationTopupBinding.inflate(layoutInflater)
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding1.root)
        dialog.setCancelable(false)
        val str = resources.getString(
            R.string.confirmation_topup,
            binding.tvNominal.text.toString(),
            metodeBayar
        )
        val styledText = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding1.tvConfirmation.text = styledText
        binding1.btnTukar.setOnClickListener {
            startActivity(Intent(this, SuccessTopupActivity::class.java))
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
            checkButton(isSelected, nominalSelected)
        } else {
            btn.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unsel)
            cardView.tag = "unselected"
            isSelected = false
            checkButton(isSelected, nominalSelected)
        }
    }

    private fun unselectedAnotherItem(btn: Button, btn1: Button, cv: CardView, cv1: CardView) {
        btn.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unsel)
        btn1.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unsel)
        cv.tag = "unselected"
        cv1.tag = "unselected"
        isSelected = false
        checkButton(isSelected, nominalSelected)
    }

    private fun checkButton(status: Boolean, nominal: Boolean) {
        if (!status or !nominal) {
            with(binding) {
                btnTukar.background = ContextCompat.getDrawable(
                    this@TopUpCoinActivity,
                    R.color.bg_btn_incative
                )
                btnTukar.setTextColor(
                    ContextCompat.getColor(
                        this@TopUpCoinActivity,
                        R.color.txt_btn_incative
                    )
                )
            }
        } else {
            with(binding) {
                btnTukar.background = ContextCompat.getDrawable(
                    this@TopUpCoinActivity,
                    R.drawable.bg_textview_blue
                )
                btnTukar.setTextColor(
                    ContextCompat.getColor(
                        this@TopUpCoinActivity,
                        R.color.pure_white
                    )
                )
            }
        }
    }

    override fun onNominalClicked(position: Int) {
        binding.tvNominal.text = resources.getString(NOMINAL_TV[position - 1])
        this.position = position
        nominalSelected = true
        checkButton(isSelected, nominalSelected)
    }

    companion object {
        private val NOMINAL_TV = intArrayOf(
            R.string.topup_nominal_1,
            R.string.topup_nominal_2,
            R.string.topup_nominal_3,
            R.string.topup_nominal_4,
        )
    }
}