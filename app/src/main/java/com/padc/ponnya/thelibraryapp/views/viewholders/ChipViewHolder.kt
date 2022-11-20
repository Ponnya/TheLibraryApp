package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderChipBinding
import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate

class ChipViewHolder(
    private val delegate: ChipDelegate,
    private val binding: ViewHolderChipBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var mListData: ListData? = null

    init {
        binding.root.setOnClickListener {
            mListData?.let { listData -> delegate.onTapChip(listData) }
        }
    }

    fun dataBinding(data: ListData) {
        mListData = data
        binding.tvChipLabel.text = data.listName
        if (data.isSelected) {
            binding.tvChipLabel.setTextColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.white
                )
            )

            binding.root.setBackgroundResource(R.drawable.background_selected_chip)
        } else {
            binding.tvChipLabel.setTextColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.secondaryTextColor
                )
            )

            binding.root.setBackgroundResource(R.drawable.background_chip)
        }

    }
}

data class ListData(
    val listName: String,
    var isSelected: Boolean = false,
)