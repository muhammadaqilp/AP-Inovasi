package com.example.apinovasi.ui.akun.referral

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetShareBinding
import com.example.apinovasi.utils.showCustomToast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetShare(
    private val activity: Activity,
    private val text: String
) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetShareBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetShareBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareWa.setOnClickListener {
//            Toast(activity).showCustomToast("Share ke WA", activity)
            val whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.type = "text/plain"
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.putExtra(
                Intent.EXTRA_TEXT,
                resources.getString(R.string.txt_share_referral, text, text)
            )
            try {
                activity.startActivity(whatsappIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast(activity).showCustomToast("Whatsapp have not been installed.", activity)
            }
        }
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
}