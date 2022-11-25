package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBookListBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class BookListViewHolder(
    private val delegate: OptionMenuAndDetailDelegate,
    private val binding: ViewHolderBookListBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var mBookVO: BookVO

    init {
        binding.btnOptionMenu.setOnClickListener {
            delegate.onTapOptionMenu(mBookVO)
        }
    }

    fun bindData(bookVO: BookVO) {
        mBookVO = bookVO
        Glide.with(binding.root)
            .load(bookVO.bookImage)
            .into(binding.ivCover)

        binding.tvBookName.text = bookVO.bookTitle
        binding.tvBookAuthor.text = bookVO.author
    }
}