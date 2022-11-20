package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSmallEbookBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class SmallEbookViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    private val binding: ViewHolderSmallEbookBinding
) : RecyclerView.ViewHolder(binding.root) {
    private var mBookVO: BookVO? = null

    init {
        binding.btnMoreEbookOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu()
        }
        binding.ivMoreEbookCover.setOnClickListener {
            mBookVO?.let { bookVO -> delegate.onTapImage(bookVO) }
        }
    }

    fun bindData(bookVO: BookVO) {
        mBookVO = bookVO
        Glide.with(binding.root)
            .load(bookVO.bookImage)
            .into(binding.ivMoreEbookCover)

        binding.tvMoreEbookName.text = bookVO.title
        binding.tvMoreEbookAuthor.text = bookVO.author
    }
}