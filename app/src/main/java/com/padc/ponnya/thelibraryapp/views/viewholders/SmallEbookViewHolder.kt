package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSmallEbookBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate

class SmallEbookViewHolder(
    private val delegate: OptionMenuDelegate,
    private val binding: ViewHolderSmallEbookBinding
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnMoreEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
    }
}