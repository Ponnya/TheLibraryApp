package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderShelvesBinding
import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate

class ShelvesViewHolder(
    private val delegate: ShelvesDelegate,
    private val binding: ViewHolderShelvesBinding
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnEnterShelve.setOnClickListener {
            delegate.onTapBtnEnterShelf()
        }
    }
}