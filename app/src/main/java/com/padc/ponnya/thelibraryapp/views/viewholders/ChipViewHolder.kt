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

    private var mPosition = 0

    init {
        binding.root.setOnClickListener {
            delegate.onTapChip(mPosition)
        }
    }

    fun dataBinding(data: DummyClass, position: Int) {
        mPosition = position
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

/**
 *Dummy Data
 *To Delete
 **/
data class DummyClass(
    var isSelected: Boolean = false,
)