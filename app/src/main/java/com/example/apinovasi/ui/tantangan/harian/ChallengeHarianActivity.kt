package com.example.apinovasi.ui.tantangan.harian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apinovasi.data.ChallengeEntity
import com.example.apinovasi.databinding.ActivityChallengeHarianBinding
import com.example.apinovasi.ui.tantangan.harian.aplive.BottomSheetAPLive
import com.example.apinovasi.utils.DataDummy
import com.example.apinovasi.utils.setStatusBarTransparentLight

class ChallengeHarianActivity : AppCompatActivity(), ChallengeListAdapter.OnChallengeClick {

    private lateinit var binding: ActivityChallengeHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparentLight(this)

        binding.ivBack.setOnClickListener { onBackPressed() }

        val challenge = DataDummy.generateListChallenge()
        val listAdapter = ChallengeListAdapter(this)
        listAdapter.setListChallenge(challenge)

        with(binding.rvChallenge) {
            layoutManager = LinearLayoutManager(this@ChallengeHarianActivity)
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    override fun onItemClicked(challenge: ChallengeEntity) {
        val bottomSheet = BottomSheetAPLive(this, challenge)
        bottomSheet.show(supportFragmentManager, ChallengeHarianActivity::class.java.simpleName)
    }
}