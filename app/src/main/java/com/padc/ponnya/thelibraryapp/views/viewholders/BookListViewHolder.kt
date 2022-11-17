package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBookListBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class BookListViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    private val binding: ViewHolderBookListBinding
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
    }
}