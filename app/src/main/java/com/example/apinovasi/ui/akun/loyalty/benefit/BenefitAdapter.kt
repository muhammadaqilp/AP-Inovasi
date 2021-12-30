package com.example.apinovasi.ui.akun.loyalty.benefit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.BenefitEntity
import com.example.apinovasi.databinding.ItemBenefitSiswabaruBinding

class BenefitAdapter(private val listener: OnItemBenefitClick) : RecyclerView.Adapter<BenefitAdapter.ViewHolder>() {

    private var listBenefit = ArrayList<BenefitEntity>()

    fun setListBenefit(benefit: List<BenefitEntity>?) {
        if (benefit == null) return
        this.listBenefit.clear()
        this.listBenefit.addAll(benefit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitAdapter.ViewHolder {
        val binding =
            ItemBenefitSiswabaruBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BenefitAdapter.ViewHolder, position: Int) {
        val benefit = listBenefit[position]
        holder.bind(benefit)
    }

    override fun getItemCount(): Int = listBenefit.size

    inner class ViewHolder(private val binding: ItemBenefitSiswabaruBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(benefit: BenefitEntity) {
            with(binding) {
                tvTitle.text = benefit.title
                tvBenefit.text = benefit.description
                Glide.with(itemView.context)
                    .load(benefit.image)
                    .into(ivIcon)
                itemView.setOnClickListener {
                    listener.onItemClicked(benefit)
                }
            }
        }
    }

    interface OnItemBenefitClick {
        fun onItemClicked(benefit: BenefitEntity)
    }
}