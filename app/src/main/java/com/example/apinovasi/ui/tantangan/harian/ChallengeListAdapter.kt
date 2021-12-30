package com.example.apinovasi.ui.tantangan.harian

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apinovasi.data.ChallengeEntity
import com.example.apinovasi.databinding.ItemChallengeHarianListBinding

class ChallengeListAdapter(private val listener: OnChallengeClick) :
    RecyclerView.Adapter<ChallengeListAdapter.ViewHolder>() {

    private var listChallenge = ArrayList<ChallengeEntity>()

    fun setListChallenge(challenge: List<ChallengeEntity>?) {
        if (challenge == null) return
        this.listChallenge.clear()
        this.listChallenge.addAll(challenge)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChallengeListAdapter.ViewHolder {
        val binding =
            ItemChallengeHarianListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeListAdapter.ViewHolder, position: Int) {
        val challenge = listChallenge[position]
        holder.bind(challenge)
    }

    override fun getItemCount(): Int = listChallenge.size

    inner class ViewHolder(private val binding: ItemChallengeHarianListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(challenge: ChallengeEntity) {
            with(binding) {
                tvTitle.text = challenge.title
                tvDeskripsi.text = challenge.description
                tvProgress.text = challenge.progress
                tvPoin.text = challenge.poin
                tvXp.text = challenge.xp
                Glide.with(itemView.context)
                    .load(challenge.image)
                    .into(ivIcon)

                itemView.setOnClickListener {
                    listener.onItemClicked(challenge)
                }
            }
        }
    }

    interface OnChallengeClick {
        fun onItemClicked(challenge: ChallengeEntity)
    }
}