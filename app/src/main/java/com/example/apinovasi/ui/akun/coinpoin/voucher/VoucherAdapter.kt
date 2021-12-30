package com.example.apinovasi.ui.akun.coinpoin.voucher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.VoucherEntity
import com.example.apinovasi.databinding.ItemVoucherBinding

class VoucherAdapter(private val listener: OnVoucherClick) :
    RecyclerView.Adapter<VoucherAdapter.ViewHolder>() {

    private var listVoucher = ArrayList<VoucherEntity>()

    fun setVoucherList(voucher: List<VoucherEntity>?) {
        if (voucher == null) return
        this.listVoucher.clear()
        this.listVoucher.addAll(voucher)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherAdapter.ViewHolder {
        val binding =
            ItemVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoucherAdapter.ViewHolder, position: Int) {
        val voucher = listVoucher[position]
        holder.bind(voucher)
    }

    override fun getItemCount(): Int = listVoucher.size

    inner class ViewHolder(private val binding: ItemVoucherBinding) :
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
                itemView.setOnClickListener {
                    listener.onVoucherClicked(voucher)
                }
            }
        }
    }

    interface OnVoucherClick {
        fun onVoucherClicked(voucher: VoucherEntity)
    }
}