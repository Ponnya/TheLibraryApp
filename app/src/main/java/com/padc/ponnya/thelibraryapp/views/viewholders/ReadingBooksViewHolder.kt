package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderReadingBooksBinding
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDetailDelegate

class ReadingBooksViewHolder(
    private val delegate: CarouselOptionMenuDetailDelegate,
    binding: ViewHolderReadingBooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnOptionMenu.setOnClickListener {
            delegate.onTapCarouselOptionMenu()
        }
        binding.ivBookCover.setOnClickListener {
            delegate.onTapCarouselImageView()
        }
    }
}