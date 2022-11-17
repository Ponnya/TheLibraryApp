package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBookListBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.BookListViewHolder

class BookListAdapter(private val delegate: OptionMenuAndDetailDelegate) :
    RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view =
            ViewHolderBookListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookListViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 8
}