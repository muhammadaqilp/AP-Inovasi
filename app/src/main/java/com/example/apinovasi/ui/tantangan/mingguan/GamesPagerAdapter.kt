package com.example.apinovasi.ui.tantangan.mingguan

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.apinovasi.ui.tantangan.mingguan.games.lostword.LostWordFragment
import com.example.apinovasi.ui.tantangan.mingguan.games.pilihanganda.PilihanGandaFragment
import com.example.apinovasi.ui.tantangan.mingguan.games.tebakgambar.TebakGambar1Fragment
import com.example.apinovasi.ui.tantangan.mingguan.games.tebakgambar.TebakGambar2Fragment
import com.example.apinovasi.ui.tantangan.mingguan.games.tebakgambar.TebakGambar5Fragment
import com.example.apinovasi.ui.tantangan.mingguan.games.terjemah.TerjemahKalimatFragment

class GamesPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TebakGambar1Fragment()
            1 -> fragment = TebakGambar2Fragment()
            2 -> fragment = TerjemahKalimatFragment()
            3 -> fragment = LostWordFragment()
            4 -> fragment = TebakGambar5Fragment()
            5 -> fragment = PilihanGandaFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 6
    }
}