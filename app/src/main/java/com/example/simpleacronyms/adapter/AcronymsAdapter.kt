package com.example.simpleacronyms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleacronyms.databinding.LongFormBinding

class AcronymsAdapter(
    var longForms: List<String>
) : RecyclerView.Adapter<AcronymsAdapter.AcronymsViewHolder>() {

    inner class AcronymsViewHolder(val binding: LongFormBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymsViewHolder {
        return AcronymsViewHolder(
            LongFormBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return longForms.size
    }

    override fun onBindViewHolder(holder: AcronymsViewHolder, position: Int) {
        holder.binding.apply {
            tvLongForm.text = longForms[position]
        }
    }
}