package com.example.fagmentnavbarhome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fagmentnavbarhome.databinding.ItemIlmuwanBinding
import com.example.fagmentnavbarhome.model.Ilmuwan

class IlmuwanAdapter(val data: (Ilmuwan)-> Unit): ListAdapter<Ilmuwan, IlmuwanAdapter.IlmuwanViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IlmuwanViewHolder {
        val binding = ItemIlmuwanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IlmuwanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IlmuwanViewHolder, position: Int) = holder.bind(getItem(position))

    inner class IlmuwanViewHolder(private val binding: ItemIlmuwanBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ilmuwan: Ilmuwan) {
            binding.apply {
                ivIlmuwan.setImageResource(ilmuwan.image)
                tvTitle.text = ilmuwan.name
            }
            itemView.setOnClickListener { data.invoke(ilmuwan) }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Ilmuwan>() {
            override fun areItemsTheSame(oldItem: Ilmuwan, newItem: Ilmuwan) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Ilmuwan, newItem: Ilmuwan) = oldItem == newItem
        }
    }
}