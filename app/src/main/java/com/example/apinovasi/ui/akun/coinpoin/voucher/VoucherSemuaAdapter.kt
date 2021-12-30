package com.example.apinovasi.ui.akun.coinpoin.voucher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.VoucherEntity
import com.example.apinovasi.databinding.ItemVoucherSemuaBinding

class VoucherSemuaAdapter(private val callback: OnVoucherClickCallback) : RecyclerView.Adapter<VoucherSemuaAdapter.ViewHolder>() {

    private var listVoucher = ArrayList<VoucherEntity>()

    fun setVoucherListSemua(voucher: List<VoucherEntity>?) {
        if (voucher == null) return
        this.listVoucher.clear()
        this.listVoucher.addAll(voucher)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VoucherSemuaAdapter.ViewHolder {
        val binding =
            ItemVoucherSemuaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoucherSemuaAdapter.ViewHolder, position: Int) {
        val voucher = listVoucher[position]
        holder.bind(voucher)
    }

    override fun getItemCount(): Int = listVoucher.size

    inner class ViewHolder(private val binding: ItemVoucherSemuaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(voucher: VoucherEntity) {
            with(binding) {
                tvTitle.text = voucher.titleVoucher
                tvProvider.text = voucher.providerVoucher
                tvJumlahCoin.text = voucher.coinVoucher
                tvJumlahPoin.text = voucher.poinVoucher
                Glide.with(itemView.context)
                    .load(voucher.posterVoucher)
                    .into(ivPoster)

                itemView.setOnClickListener { callback.onVoucherClicked(voucher) }
            }
        }
    }

    interface OnVoucherClickCallback {
        fun onVoucherClicked(voucher: VoucherEntity)
    }
}