package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSearchBookBinding
import com.padc.ponnya.thelibraryapp.delegates.SearchBookDelegate

class SearchBookViewHolder(
    private val delegate: SearchBookDelegate, private val binding: ViewHolderSearchBookBinding
) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var mBookVO: BookVO

    init {
        binding.root.setOnClickListener {
            delegate.onTapBook(mBookVO)
        }

    }

    fun bindData(bookVO: BookVO) {
        mBookVO = bookVO
        println(bookVO.bookImage)
        Glide.with(binding.root).load(bookVO.bookImage).into(binding.ivCover)
        binding.tvBookName.text = bookVO.bookTitle
        binding.tvBookAuthor.text = bookVO.author
    }
}