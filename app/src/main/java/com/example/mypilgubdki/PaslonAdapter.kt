package com.example.mypilgubdki

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypilgubdki.databinding.ItemPilgubBinding

typealias OnClickPaslon = (Paslon) -> Unit

class PaslonAdapter(
    private val ListPaslon: List<Paslon>,
    private val onClickPaslon: OnClickPaslon
) : RecyclerView.Adapter<PaslonAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemPilgubBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Paslon) {
            with(binding) {
                imgCagub.setImageResource(data.imgCagub)
                namaCagub.text = data.namaCagub
                partaiPendukungCagub.text = data.partaiPendukungCagub
                imgCawagub.setImageResource(data.imgCawagub)
                namaCawagub.text = data.namaCawagub
                partaiPendukungCawagub.text = data.partaiPendukungCawagub

                itemView.setOnClickListener {
                    onClickPaslon(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemPilgubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ListPaslon.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(ListPaslon[position])
    }
}
