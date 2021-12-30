package com.example.apinovasi.ui.akun.referral

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apinovasi.databinding.ActivityReferralBinding
import com.example.apinovasi.ui.akun.referral.syarat_ketentuan.SyaratKetentuanActivity
import com.example.apinovasi.ui.akun.referral.teman_diundang.TemanDiundangActivity
import com.example.apinovasi.ui.akun.referral.tutorial.ReferralTutorialActivity
import com.example.apinovasi.utils.setStatusBarTransparentLight
import com.example.apinovasi.utils.showCustomToast

class ReferralActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReferralBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferralBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { finish() }

        binding.tvTutorialReferral.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ReferralTutorialActivity::class.java
                )
            )
        }

        binding.ivSalin.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val data =
                ClipData.newPlainText("AP Referral Code", binding.tvReferralCode.text.toString())
            clipboard.setPrimaryClip(data)
            Toast(this).showCustomToast(
                "Kode ajak temanmu berhasil disalin", this
            )
        }

        binding.ivShare.setOnClickListener {
            val bottomSheet = BottomSheetShare(this, binding.tvReferralCode.text.toString())
            bottomSheet.show(supportFragmentManager, ReferralActivity::class.java.simpleName)
//            val intent = Intent()
//            intent.action = Intent.ACTION_SEND
//            intent.type = "text/plain"
//            intent.putExtra(Intent.EXTRA_TEXT, "Hello Guys My Name is Sobat")
//            startActivity(Intent.createChooser(intent, "Share"))
        }

        binding.tvReferralTeman1.setOnClickListener {
            startActivity(Intent(this, TemanDiundangActivity::class.java))
        }

        binding.tvSk.setOnClickListener {
            startActivity(Intent(this, SyaratKetentuanActivity::class.java))
        }
    }
}