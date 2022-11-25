package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderReadingBooksBinding
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDetailDelegate

class ReadingBooksViewHolder(
    private val delegate: CarouselOptionMenuDetailDelegate,
    private val binding: ViewHolderReadingBooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var bookVO: BookVO

    init {
        binding.btnOptionMenu.setOnClickListener {
            delegate.onTapCarouselOptionMenu(bookVO)
        }
        binding.ivBookCover.setOnClickListener {
            delegate.onTapCarouselImageView()
        }
    }

    fun bindData(book: BookVO) {
        bookVO = book
        Glide.with(binding.root)
            .load(book.bookImage)
            .into(binding.ivBookCover)
    }
}