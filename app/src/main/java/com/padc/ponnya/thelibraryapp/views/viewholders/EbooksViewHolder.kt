package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class EbooksViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    private val binding: ViewHolderEbooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    private var mBook: BookVO? = null

    init {
        binding.btnEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
        binding.ivEbookCover.setOnClickListener {
            mBook?.let { it1 -> delegate.onTapImage(it1) }

        }
    }

    fun bindData(book: BookVO) {
        mBook = book
        Glide.with(binding.root)
            .load(book.bookImage)
            .into(binding.ivEbookCover)
        binding.tvEbookName.text = book.title
        binding.tvEbookAuthor.text = book.author
    }
}