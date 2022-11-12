package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderMoreEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate

class MoreEbooksViewHolder(
    private val delegate: OptionMenuDelegate,
    binding: ViewHolderMoreEbooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnMoreEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
    }
}