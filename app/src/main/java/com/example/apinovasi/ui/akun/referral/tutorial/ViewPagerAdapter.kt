package com.example.apinovasi.ui.akun.referral.tutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ContentReferralSliderBinding

class ViewPagerAdapter(
    private val context: Context
) : PagerAdapter() {

    private val titleTop = arrayOf(
        "Buka menu \"Ajak Teman\" di bagian \"Account\"",
        "Gampang banget! \n" +
                "Salin dan bagikan Kode Referralmu ke semua teman",
        "Kamu juga bisa salin kodemu dan bagikan secara manual ke teman-temanmu",
        "Ajak sepuluh teman bergabung menjadi Sobat Pintar! Dapatkan ratusan poin dan tukarkan ke beragam benefitnya!"
    )

    private val imageTop = intArrayOf(
        R.drawable.ic_frame_tutorial1,
        R.drawable.ic_frame_tutorial2,
        R.drawable.ic_frame_tutorial3,
        R.drawable.ic_frame_tutorial4
    )

    override fun getCount(): Int = titleTop.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        val view = ContentReferralSliderBinding.inflate(
            mLayoutInflater as LayoutInflater,
            container,
            false
        )

        Glide.with(context)
            .load(imageTop[position])
            .into(view.ivTutorial)


        view.tvContent.text = titleTop[position]

        container.addView(view.root)
        return view.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}