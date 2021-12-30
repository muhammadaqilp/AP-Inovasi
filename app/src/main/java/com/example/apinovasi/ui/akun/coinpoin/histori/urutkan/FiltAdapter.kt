package com.example.apinovasi.ui.akun.coinpoin.histori.urutkan

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apinovasi.R

class FiltAdapter(private val context: Context) : BaseAdapter() {

    private var listFilter = ArrayList<ItemUrutkanEnt>()

    fun setList(filter: List<ItemUrutkanEnt>?) {
        if (filter == null) return
        this.listFilter.clear()
        this.listFilter.addAll(filter)
    }

    override fun getCount(): Int {
        return listFilter.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_urutkan, p2, false)

        val txt = view.findViewById<TextView>(R.id.tv_urutkan)
//        val img = view.findViewById<ImageView>(R.id.iv_arrow)

        txt.text = listFilter[p0].name
//        if (p0 == 0){
//            img.visibility = View.VISIBLE
//        }



        return view
    }
}