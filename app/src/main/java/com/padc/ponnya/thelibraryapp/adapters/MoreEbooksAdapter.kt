package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderMoreEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.MoreEbooksViewHolder

class MoreEbooksAdapter(private val delegate: OptionMenuAndDetailDelegate) :
    RecyclerView.Adapter<MoreEbooksViewHolder>() {
    private var mBookList: List<BookVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreEbooksViewHolder {
        val view =
            ViewHolderMoreEbooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoreEbooksViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: MoreEbooksViewHolder, position: Int) {
        if (mBookList.isNotEmpty()) {
            holder.bindData(mBookList[position])
        }
    }

    override fun getItemCount(): Int = mBookList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>) {
        mBookList = bookList
        notifyDataSetChanged()
    }
}