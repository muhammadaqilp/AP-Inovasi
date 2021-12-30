package com.example.apinovasi.ui.akun.referral.tutorial

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.apinovasi.R
import com.example.apinovasi.databinding.ActivityReferralTutorialBinding
import com.example.apinovasi.utils.setStatusBarLight

class ReferralTutorialActivity : AppCompatActivity(), OnPageChangeListener {

    private lateinit var binding: ActivityReferralTutorialBinding
    private var pos: Int = 0

    private val drawSel = intArrayOf(
        R.drawable.ic_tutorial1_sel,
        R.drawable.ic_tutorial2_sel,
        R.drawable.ic_tutorial3_sel,
        R.drawable.ic_tutorial4_sel
    )

    private val draw = intArrayOf(
        R.drawable.ic_tutorial1,
        R.drawable.ic_tutorial2,
        R.drawable.ic_tutorial3,
        R.drawable.ic_tutorial4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferralTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarLight(this)

        binding.ivExit.setOnClickListener { finish() }

        val adapter = ViewPagerAdapter(this)
        binding.vpTutorial.adapter = adapter
        binding.vpTutorial.addOnPageChangeListener(this)

        if (pos == 0) binding.ivPrev.visibility = View.INVISIBLE
        changeIndicator(pos)

        binding.ivNext.setOnClickListener { binding.vpTutorial.currentItem = pos + 1 }
        binding.ivPrev.setOnClickListener { binding.vpTutorial.currentItem = pos - 1 }
        binding.iv1.setOnClickListener {
            binding.vpTutorial.currentItem = 0
            changeIndicator(0)
        }
        binding.iv2.setOnClickListener {
            binding.vpTutorial.currentItem = 1
            changeIndicator(1)
        }
        binding.iv3.setOnClickListener {
            binding.vpTutorial.currentItem = 2
            changeIndicator(2)
        }
        binding.iv4.setOnClickListener {
            binding.vpTutorial.currentItem = 3
            changeIndicator(3)
        }
    }

    override fun onPageSelected(position: Int) {
        pos = position
        changeIndicator(position)
    }

    private fun changeIndicator(position: Int) {
        val drawB = arrayOf(
            binding.iv1,
            binding.iv2,
            binding.iv3,
            binding.iv4,
        )

        when (position) {
            0 -> {
                binding.ivPrev.visibility = View.INVISIBLE
                binding.ivNext.visibility = View.VISIBLE
            }
            3 -> {
                binding.ivNext.visibility = View.INVISIBLE
                binding.ivPrev.visibility = View.VISIBLE
            }
            else -> {
                binding.ivPrev.visibility = View.VISIBLE
                binding.ivNext.visibility = View.VISIBLE
            }
        }

        for (i in 0..3) {
            drawB[i].setImageResource(draw[i])
        }
        if (drawB.isNotEmpty()) drawB[position].setImageResource(drawSel[position])
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}
}