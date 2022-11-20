package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderEbooksBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.EbooksViewHolder

class EbooksAdapter(private val delegate: OptionMenuAndDetailDelegate) :
    RecyclerView.Adapter<EbooksViewHolder>() {

    private var mBookList: List<BookVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbooksViewHolder {
        val view =
            ViewHolderEbooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EbooksViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: EbooksViewHolder, position: Int) {
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