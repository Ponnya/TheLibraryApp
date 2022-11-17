package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class EbooksViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    binding: ViewHolderEbooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
        binding.ivEbookCover.setOnClickListener {
            delegate.onTapImage()
        }
    }
}