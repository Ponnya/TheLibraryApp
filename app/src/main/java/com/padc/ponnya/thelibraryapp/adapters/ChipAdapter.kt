package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderChipBinding
import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.ChipViewHolder
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

class ChipAdapter(private val delegate: ChipDelegate) : RecyclerView.Adapter<ChipViewHolder>() {
    private var mData: List<ListData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        val view = ViewHolderChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChipViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        holder.dataBinding(mData[position])

    }

    override fun getItemCount(): Int = mData.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(data: List<ListData>) {
        mData = data
        notifyDataSetChanged()
    }
}