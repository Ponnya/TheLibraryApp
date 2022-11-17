package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBooksByCategoryBinding
import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.BooksByCategoryViewHolder

class BooksByCategoryAdapter(
    private val mOptionMenuDelegate: OptionMenuAndDetailDelegate,
    private val delegate: BooksByCategoryDelegate
) :
    RecyclerView.Adapter<BooksByCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksByCategoryViewHolder {
        val view = ViewHolderBooksByCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BooksByCategoryViewHolder(mOptionMenuDelegate, delegate, view)
    }

    override fun onBindViewHolder(holder: BooksByCategoryViewHolder, position: Int) {
        holder.setNewData()
    }

    override fun getItemCount(): Int = 4
}