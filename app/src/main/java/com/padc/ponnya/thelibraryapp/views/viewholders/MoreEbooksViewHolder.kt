package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderMoreEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class MoreEbooksViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    binding: ViewHolderMoreEbooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnMoreEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
        binding.ivMoreEbookCover.setOnClickListener {
            delegate.onTapImage()
        }
    }
}