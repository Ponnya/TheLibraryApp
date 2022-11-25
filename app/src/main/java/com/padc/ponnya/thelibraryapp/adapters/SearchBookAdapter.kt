package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSearchBookBinding
import com.padc.ponnya.thelibraryapp.delegates.SearchBookDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.SearchBookViewHolder

class SearchBookAdapter(private var delegate: SearchBookDelegate) : RecyclerView.Adapter<SearchBookViewHolder>() {
    private var mBookList: List<BookVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val view =
            ViewHolderSearchBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(delegate,view)
    }

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
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