package com.example.apinovasi.ui.akun.coinpoin.aksespremium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.AksesPremiumEntity
import com.example.apinovasi.databinding.ItemAksesPremiumSemuaBinding

class AksesPremiumSemuaAdapter : RecyclerView.Adapter<AksesPremiumSemuaAdapter.ViewHolder>() {

    private var listAkses = ArrayList<AksesPremiumEntity>()

    fun setAksesListSemua(akses: List<AksesPremiumEntity>?) {
        if (akses == null) return
        this.listAkses.clear()
        this.listAkses.addAll(akses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AksesPremiumSemuaAdapter.ViewHolder {
        val binding =
            ItemAksesPremiumSemuaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AksesPremiumSemuaAdapter.ViewHolder, position: Int) {
        val akses = listAkses[position]
        holder.bind(akses)
    }

    override fun getItemCount(): Int = listAkses.size

    inner class ViewHolder(private val binding: ItemAksesPremiumSemuaBinding) :
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