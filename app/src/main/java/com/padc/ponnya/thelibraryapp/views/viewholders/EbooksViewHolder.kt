package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate

class EbooksViewHolder(private val delegate: OptionMenuDelegate, binding: ViewHolderEbooksBinding) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
    }
}