package com.example.hm_6_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hm_6_3.databinding.ItemBinding

class HintAdapter(val onItemClick: (hint: String) -> Unit): Adapter<HintAdapter.HintViewHodler>() {

    private val data = arrayListOf<String>()

    fun addData(newData: ArrayList<String>){
            data.clear()
            data.addAll(newData)
            notifyDataSetChanged()
    }

    inner class HintViewHodler(private val binding: ItemBinding): ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.tvHint.text = s
            itemView.setOnClickListener{
                onItemClick(s)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintViewHodler {
            return HintViewHodler(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HintViewHodler, position: Int) {
        holder.bind(data[position])

    }
}