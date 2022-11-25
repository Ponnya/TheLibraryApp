package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderMoreEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class MoreEbooksViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    private val binding: ViewHolderMoreEbooksBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    private var mBookVO: BookVO? = null

    init {
        binding.btnMoreEbookOptionMenu.setOnClickListener {
            mBookVO?.let { book -> delegate.onTapOptionMenu(book) }
        }
        binding.ivMoreEbookCover.setOnClickListener {
            mBookVO?.let { bookVO -> delegate.onTapImage(bookVO) }

        }
    }

    fun bindData(bookVO: BookVO) {
        mBookVO = bookVO
        if (bookVO.bookImage != null) {
            Glide.with(binding.root)
                .load(bookVO.bookImage)
                .into(binding.ivMoreEbookCover)
        }
        else{
            Glide.with(binding.root)
                .load(R.drawable.book_cover)
                .into(binding.ivMoreEbookCover)
        }


        binding.tvMoreEbookName.text = bookVO.bookTitle
        binding.tvMoreEbookAuthor.text = bookVO.author
    }
}