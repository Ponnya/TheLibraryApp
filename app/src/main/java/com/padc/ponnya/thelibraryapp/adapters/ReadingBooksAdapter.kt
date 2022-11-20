package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderReadingBooksBinding
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.ReadingBooksViewHolder

class ReadingBooksAdapter(private val delegate: CarouselOptionMenuDetailDelegate) :
    RecyclerView.Adapter<ReadingBooksViewHolder>() {

    private var mBookList: List<BookVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadingBooksViewHolder {
        val view = ViewHolderReadingBooksBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReadingBooksViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: ReadingBooksViewHolder, position: Int) {
        if (mBookList.isNotEmpty())
            holder.bindData(mBookList[position])
    }

    override fun getItemCount(): Int = mBookList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>) {
        mBookList = bookList
        notifyDataSetChanged()
    }


}