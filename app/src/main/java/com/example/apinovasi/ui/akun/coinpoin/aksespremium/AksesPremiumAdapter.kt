package com.example.apinovasi.ui.akun.coinpoin.aksespremium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.AksesPremiumEntity
import com.example.apinovasi.databinding.ItemAksesPremiumBinding

class AksesPremiumAdapter : RecyclerView.Adapter<AksesPremiumAdapter.ViewHolder>() {

    private var listAkses = ArrayList<AksesPremiumEntity>()

    fun setAksesList(akses: List<AksesPremiumEntity>?) {
        if (akses == null) return
        this.listAkses.clear()
        this.listAkses.addAll(akses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AksesPremiumAdapter.ViewHolder {
        val binding =
            ItemAksesPremiumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AksesPremiumAdapter.ViewHolder, position: Int) {
        val akses = listAkses[position]
        holder.bind(akses)
    }

    override fun getItemCount(): Int = listAkses.size

    inner class ViewHolder(private val binding: ItemAksesPremiumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(akses: AksesPremiumEntity) {
            with(binding) {
                tvTitle.text = akses.titleAkses
                tvProvider.text = akses.providerAkses
                tvJumlahKoin.text = akses.coinAkses
                Glide.with(itemView.context)
                    .load(akses.posterAkses)
                    .into(ivPoster)
            }
        }
    }
}